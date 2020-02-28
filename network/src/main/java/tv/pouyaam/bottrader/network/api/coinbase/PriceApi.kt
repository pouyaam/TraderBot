package tv.pouyaam.bottrader.network.api.coinbase

import retrofit2.http.GET
import retrofit2.http.Query
import tv.pouyaam.bottrader.network.model.coinbase.price.ResponsePrice

interface PriceApi {
    @GET("v2/prices/spot")
    suspend fun price(@Query("currency") currency: String) : ResponsePrice
}