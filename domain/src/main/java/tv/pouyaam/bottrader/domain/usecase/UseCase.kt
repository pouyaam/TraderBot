package tv.pouyaam.bottrader.domain.usecase

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import tv.pouyaam.bottrader.repository.Repository
import tv.pouyaam.bottrader.domain.transformation.Transformation

abstract class UseCase<REQUEST, RESPONSE, DOMAIN>(
    private val repository: Repository<REQUEST, RESPONSE>,
    private val transformation: Transformation<RESPONSE, DOMAIN>
) {
    fun execute(parameter: REQUEST): Flow<DOMAIN> = flow {
        emit(
            transformation.transform(
                repository.invoke(parameter)
            )
        )
    }
}