package tv.pouyaam.bottrader.repository.cryptocompare.historical.daily

import tv.pouyaam.bottrader.network.api.cryptocompare.HistoricalApi
import tv.pouyaam.bottrader.network.model.cryptocompare.historical.RequestHistorical
import tv.pouyaam.bottrader.network.model.cryptocompare.historical.daily.ResponseHistoricalDaily
import tv.pouyaam.bottrader.repository.Repository

class HistoricalRepositoryDailyImpl(private val historicalApi: HistoricalApi) : HistoricalRepositoryDaily() {
    override suspend fun invoke(parameter: RequestHistorical): ResponseHistoricalDaily =
        historicalApi.histoday(parameter.symbol, parameter.currency, parameter.limit)

}