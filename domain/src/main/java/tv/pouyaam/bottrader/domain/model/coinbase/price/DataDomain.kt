package tv.pouyaam.bottrader.domain.model.coinbase.price

data class DataDomain (
	val amount: String,
	val currency: String
) {
	override fun toString(): String {
		return "DataDomain(amount='$amount', currency='$currency')"
	}
}