package tv.pouyaam.bottrader.network.model.coinbase.price

import com.google.gson.annotations.SerializedName

data class Data(

	@SerializedName("amount")
	val amount: String? = null,

	@SerializedName("currency")
	val currency: String? = null
)