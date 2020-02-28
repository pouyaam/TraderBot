package tv.pouyaam.bottrader.domain.model.cryptocompare.historical.daily

data class DataDomain(
	val aggregated: Boolean,
	val timeFrom: Int,
	val timeTo: Int,
	val data: List<DataItemDomain>
)