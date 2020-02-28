package tv.pouyaam.bottrader.network.model.cryptocompare.historical.daily

import com.google.gson.annotations.SerializedName

data class ResponseHistoricalDaily(

	@SerializedName("Response")
	val response: String? = null,

	@SerializedName("Type")
	val type: Int? = null,

	@SerializedName("Message")
	val message: String? = null,

	@SerializedName("HasWarning")
	val hasWarning: Boolean? = null,

	@SerializedName("Data")
	val data: Data? = null
)