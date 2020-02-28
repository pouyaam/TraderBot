package tv.pouyaam.bottrader.domain.model.cryptocompare.historical.daily

data class DataItemDomain(
	val high: Double,
	val low: Double,
	val conversionSymbol: String,
	val volumeto: Double,
	val volumefrom: Double,
	val time: Int,
	val conversionType: String,
	val close: Double,
	val open: Double
)