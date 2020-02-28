package tv.pouyaam.bottrader.domain.model.cryptocompare.historical

data class RequestHistoricalDomain(
    val symbol: String,
    val currency: String,
    val limit: Int
)