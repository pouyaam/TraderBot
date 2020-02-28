package tv.pouyaam.bottrader.network.model.cryptocompare.historical

data class RequestHistorical(
    val symbol: String,
    val currency: String,
    val limit: Int
)