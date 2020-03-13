package tv.pouyaam.bottrader.navigation.result

import android.util.Log
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import tv.pouyaam.bottrader.navigation.domain.NavResultDomain

abstract class NavResultHandler {
    val resultMap: HashMap<String, NavResultDomain> = hashMapOf()

    abstract fun sendWithMap(owner: String, channelName: String, payload: Any)
    abstract fun receiveWithFlow(owner: String): Flow<NavResultDomain>
}