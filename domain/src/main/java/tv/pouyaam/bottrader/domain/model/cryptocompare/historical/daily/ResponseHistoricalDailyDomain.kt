package tv.pouyaam.bottrader.domain.model.cryptocompare.historical.daily

data class ResponseHistoricalDailyDomain(
	val response: String,
	val type: Int,
	val message: String,
	val hasWarning: Boolean,
	val dataDomain: DataDomain
)