package tv.pouyaam.transformation.coinbase.price

import tv.pouyaam.model.price.DataDomain
import tv.pouyaam.network.model.price.Data

class DataTransformationImpl : DataTransformation() {
    override fun transform(response: Data): DataDomain =
        DataDomain(
            response.amount ?: "",
            response.currency ?: ""
        )
}