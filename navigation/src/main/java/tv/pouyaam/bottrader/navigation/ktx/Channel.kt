package tv.pouyaam.bottrader.navigation.ktx

import android.util.Log
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import tv.pouyaam.bottrader.navigation.domain.NavResultDomain

@ExperimentalCoroutinesApi
@FlowPreview
fun Channel<NavResultDomain>.onResult(handler: ((resultDomain: NavResultDomain) -> Unit)?): Channel<NavResultDomain> {
    CoroutineScope(Dispatchers.IO).launch {
        Log.d("CHANNELS", "onResult= $this")
        consumeAsFlow()
            .flowOn(Dispatchers.Main)
            .conflate()
            .collect { handler?.invoke(it) }
    }
    return this
}