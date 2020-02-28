package tv.pouyaam.bottrader.network.model.cryptocompare.historical.daily

import com.google.gson.annotations.SerializedName

data class Data(

	@SerializedName("Aggregated")
	val aggregated: Boolean? = null,

	@SerializedName("TimeFrom")
	val timeFrom: Int? = null,

	@SerializedName("TimeTo")
	val timeTo: Int? = null,

	@SerializedName("Data")
	val data: List<DataItem>? = null
)