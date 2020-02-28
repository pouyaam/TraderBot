package tv.pouyaam.bottrader.domain.transformation.cryptocompare.historical

import tv.pouyaam.bottrader.domain.model.cryptocompare.historical.daily.DataDomain
import tv.pouyaam.bottrader.domain.model.cryptocompare.historical.daily.DataItemDomain
import tv.pouyaam.bottrader.network.model.cryptocompare.historical.daily.Data
import tv.pouyaam.bottrader.network.model.cryptocompare.historical.daily.DataItem
import tv.pouyaam.transformation.Transformation

class DataItemTransformationImpl : DataItemTransformation() {
    override fun transform(response: DataItem): DataItemDomain =
        DataItemDomain(
            response.high ?: 0.0,
            response.low ?: 0.0,
            response.conversionSymbol ?: "",
            response.volumeto ?: 0.0,
            response.volumefrom ?: 0.0,
            response.time ?:0,
            response.conversionType ?: "",
            response.close ?: 0.0,
            response.open ?: 0.0
        )
}