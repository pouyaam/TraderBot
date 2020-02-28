package tv.pouyaam.bottrader.domain.transformation.cryptocompare.historical

import tv.pouyaam.bottrader.domain.model.cryptocompare.historical.daily.DataDomain
import tv.pouyaam.bottrader.network.model.cryptocompare.historical.daily.Data
import tv.pouyaam.transformation.Transformation

class DataTransformationImpl(private val dateItemTransformation: DataItemTransformation) : DataTransformation() {
    override fun transform(response: Data): DataDomain =
        DataDomain(
            response.aggregated ?: false,
            response.timeFrom ?: 0,
            response.timeTo ?: 0,
            response.data?.map { dateItemTransformation.transform(it) } ?: listOf()
        )

}