package tv.pouyaam.bottrader.domain.usecase

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CoroutineNetworkJob {
    suspend fun <DOMAIN: Any?> execute(work: suspend () -> DOMAIN, networkJob: NetworkJob<DOMAIN>.() -> Unit) {
        var dataSource : DOMAIN? = null
        val callback = NetworkJob<DOMAIN>().apply(networkJob)
        var error: Throwable? = null

        callback.onStart?.invoke()

        withContext(Dispatchers.IO) {
            try {
                dataSource = work()
            } catch (throwable: Throwable) {
                error = throwable
            }
        }
        dataSource?.also { callback.onComplete?.invoke(it) }
        error?.also { callback.onError?.invoke(it) }
    }

    class NetworkJob<DOMAIN> {
        var onComplete: ((DOMAIN) -> Unit)? = null
        var onError: ((Throwable) -> Unit)? = null
        var onStart: (() -> Unit)? = null
    }
}