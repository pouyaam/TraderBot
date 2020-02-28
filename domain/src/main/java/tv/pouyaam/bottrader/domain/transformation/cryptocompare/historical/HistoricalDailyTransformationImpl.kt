package tv.pouyaam.bottrader.domain.transformation.cryptocompare.historical

import tv.pouyaam.bottrader.domain.model.cryptocompare.historical.daily.ResponseHistoricalDailyDomain
import tv.pouyaam.bottrader.network.model.cryptocompare.historical.daily.Data
import tv.pouyaam.bottrader.network.model.cryptocompare.historical.daily.ResponseHistoricalDaily

class HistoricalDailyTransformationImpl(private val dataTransformation: DataTransformation) : HistoricalDailyTransformation() {
    override fun transform(response: ResponseHistoricalDaily): ResponseHistoricalDailyDomain =
        ResponseHistoricalDailyDomain(
            response.response ?: "",
            response.type ?: 0,
            response.message ?: "",
            response.hasWarning ?: false,
            dataTransformation.transform(response.data ?: Data())
        )
}