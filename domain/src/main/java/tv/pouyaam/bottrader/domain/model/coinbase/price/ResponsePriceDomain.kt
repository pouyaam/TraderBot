package tv.pouyaam.bottrader.domain.model.coinbase.price

data class ResponsePriceDomain(
	val dataDomain: DataDomain
) {
	override fun toString(): String {
		return "ResponsePriceDomain(dataDomain=$dataDomain)"
	}
}