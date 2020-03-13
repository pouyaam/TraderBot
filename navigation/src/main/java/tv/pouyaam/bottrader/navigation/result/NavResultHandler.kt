package tv.pouyaam.bottrader.navigation.result

import android.util.Log
import kotlinx.coroutines.channels.Channel
import tv.pouyaam.bottrader.navigation.domain.NavResultDomain
import tv.pouyaam.bottrader.navigation.ktx.send

abstract class NavResultHandler {
    var resultChannel: Channel<NavResultDomain> = Channel()

    abstract fun send(channelName: String, payload: Any)
    abstract fun newChannel(): NavResultHandler
}