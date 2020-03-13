package tv.pouyaam.bottrader.navigation.domain

data class NavResultDomain(val channelName: String, val payload: Any) {
    override fun toString(): String {
        return "NavResultDomain(key='$channelName', payload=$payload)"
    }
}