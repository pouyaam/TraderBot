package tv.pouyaam.bottrader.navigation.result

import android.util.Log
import kotlinx.coroutines.channels.Channel
import tv.pouyaam.bottrader.navigation.domain.NavResultDomain
import tv.pouyaam.bottrader.navigation.ktx.send

class NavResultHandlerImpl : NavResultHandler() {

    override fun send(channelName: String, payload: Any) {
        Log.d("CHANNELS", "sending payload= $payload in channel= $resultChannel with name= $channelName")
        resultChannel.send(channelName, payload)
    }

    override fun newChannel(): NavResultHandler {
        resultChannel.close()
        resultChannel = Channel()
        return this
    }
}

