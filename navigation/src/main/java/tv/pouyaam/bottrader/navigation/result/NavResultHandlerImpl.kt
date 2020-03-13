package tv.pouyaam.bottrader.navigation.result

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import tv.pouyaam.bottrader.navigation.domain.NavResultDomain

class NavResultHandlerImpl : NavResultHandler() {

    override fun receiveWithFlow(owner: String): Flow<NavResultDomain> = flow {
        resultMap.remove(owner)?.let {
            emit(it)
        }
    }

    override fun sendWithMap(owner: String, channelName: String, payload: Any) {
        resultMap.remove(owner)
        resultMap[owner] = NavResultDomain(channelName, payload)
    }
}

