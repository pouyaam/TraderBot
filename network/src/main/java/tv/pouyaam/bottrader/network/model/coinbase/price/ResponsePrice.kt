package tv.pouyaam.bottrader.network.model.coinbase.price

import com.google.gson.annotations.SerializedName

data class ResponsePrice(

	@SerializedName("data")
	val data: Data? = null
)