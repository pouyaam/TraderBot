package tv.pouyaam.bottrader.domain.transformation.coinbase.price

import tv.pouyaam.bottrader.domain.model.coinbase.price.DataDomain
import tv.pouyaam.bottrader.network.model.coinbase.price.Data

class DataTransformationImpl : DataTransformation() {
    override fun transform(response: Data): DataDomain =
        DataDomain(
            response.amount ?: "",
            response.currency ?: ""
        )
}