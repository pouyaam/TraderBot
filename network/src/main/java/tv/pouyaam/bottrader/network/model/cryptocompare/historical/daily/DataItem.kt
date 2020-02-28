package tv.pouyaam.bottrader.network.model.cryptocompare.historical.daily

import com.google.gson.annotations.SerializedName

data class DataItem(

	@SerializedName("high")
	val high: Double? = null,

	@SerializedName("low")
	val low: Double? = null,

	@SerializedName("conversionSymbol")
	val conversionSymbol: String? = null,

	@SerializedName("volumeto")
	val volumeto: Double? = null,

	@SerializedName("volumefrom")
	val volumefrom: Double? = null,

	@SerializedName("time")
	val time: Int? = null,

	@SerializedName("conversionType")
	val conversionType: String? = null,

	@SerializedName("close")
	val close: Double? = null,

	@SerializedName("open")
	val open: Double? = null
)