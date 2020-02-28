package tv.pouyaam.bottrader.network.api.cryptocompare

import retrofit2.http.GET
import retrofit2.http.Query
import tv.pouyaam.bottrader.network.model.cryptocompare.historical.daily.ResponseHistoricalDaily

interface HistoricalApi {
    @GET("data/v2/histoday")
    suspend fun histoday(@Query("fsym") symbol: String, @Query("tsym") currency: String, @Query("limit") limit: Int) : ResponseHistoricalDaily
}