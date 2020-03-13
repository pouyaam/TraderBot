package tv.pouyaam.bottrader.navigation.ktx

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import tv.pouyaam.bottrader.navigation.domain.NavResultDomain

@ExperimentalCoroutinesApi
@FlowPreview
fun Flow<NavResultDomain>.onResult(handler: ((resultDomain: NavResultDomain) -> Unit)?) {
    CoroutineScope(Dispatchers.Main).launch {
        collect { handler?.invoke(it) }
    }
}

