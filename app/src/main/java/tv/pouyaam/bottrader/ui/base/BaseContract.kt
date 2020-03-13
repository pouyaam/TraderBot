package tv.pouyaam.bottrader.ui.base

import androidx.navigation.NavDirections
import tv.pouyaam.bottrader.navigation.domain.NavResultDomain

interface BaseContract {
    fun navigateToDirection(direction: NavDirections)
    fun popWithResult(channelName: String, payload: Any)
}