package tv.pouyaam.bottrader.domain.usecase

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import tv.pouyaam.bottrader.repository.Repository
import tv.pouyaam.transformation.Transformation

abstract class UseCase<REQUEST, RESPONSE, DOMAIN>(
    private val repository: Repository<REQUEST, RESPONSE>,
    private val transformation: Transformation<RESPONSE, DOMAIN>
) {
    private val result: MutableLiveData<DOMAIN> = MutableLiveData()

    suspend fun execute(parameter: REQUEST, networkJob: CoroutineNetworkJob.NetworkJob<DOMAIN>.() -> Unit) : LiveData<DOMAIN> {
        val callback = CoroutineNetworkJob.NetworkJob<DOMAIN>().apply(networkJob)
        CoroutineNetworkJob().execute(work = { transformation.transform(repository.invoke(parameter)) }) {
            onStart = callback.onStart

            onComplete = {
                result.postValue(it)
                callback.onComplete?.invoke(it)
            }

            onError = {
                //SOME Logics
                it.printStackTrace()
                callback.onError?.invoke(it)
            }
        }

        return result
    }
}