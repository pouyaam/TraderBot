package tv.pouyaam.bottrader.common.ktx

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*

@ExperimentalCoroutinesApi
fun <T, R> Flow<T>.launchInScopeAndOnEach(
    scope: CoroutineScope,
    startAction: ((Unit) -> Unit)? = null,
    transform: ((Value: T) -> R)? = null,
    action: ((R) -> Unit)? = null,
    error: ((Throwable) -> Unit)? = null
) {
    startAction?.invoke(Unit)
    flowOn(Dispatchers.IO)
        .map { transform?.invoke(it) ?: it }
        .flowOn(Dispatchers.Main)
        .onEach { (it as? R)?.also { action?.invoke(it) } }
        .catch {
            it.printStackTrace()
            error?.invoke(it)
        }
        .launchIn(scope)
}

@ExperimentalCoroutinesApi
fun <T> Flow<T>.launchInScopeAndOnEach(
    scope: CoroutineScope,
    startAction: ((Unit) -> Unit)? = null,
    action: ((T) -> Unit)? = null,
    error: ((Throwable) -> Unit)? = null
) {
    startAction?.invoke(Unit)
    flowOn(Dispatchers.IO)
        .flowOn(Dispatchers.Main)
        .onEach { action?.invoke(it)  }
        .catch {
            it.printStackTrace()
            error?.invoke(it)
        }
        .launchIn(scope)
}