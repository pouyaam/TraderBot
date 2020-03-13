package tv.pouyaam.bottrader.navigation.ktx

import android.util.Log
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.flow.flowOn
import tv.pouyaam.bottrader.navigation.domain.NavResultDomain

fun Channel<NavResultDomain>.send(key: String, payload: Any) {
    CoroutineScope(Dispatchers.IO).launch { send(NavResultDomain(key, payload)) }
}

@ExperimentalCoroutinesApi
@FlowPreview
fun Channel<NavResultDomain>.onResult(handler: ((resultDomain: NavResultDomain) -> Unit)?) : Channel<NavResultDomain> {
    CoroutineScope(Dispatchers.IO).launch {
        Log.d("CHANNELS", "onResult= $this")
        consumeAsFlow()
            .flowOn(Dispatchers.Main)
            .buffer()
            .collect { handler?.invoke(it) }
    }
    return this
}