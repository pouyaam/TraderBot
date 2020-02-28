package tv.pouyaam.transformation.coinbase.price

import tv.pouyaam.model.price.ResponsePriceDomain
import tv.pouyaam.network.model.price.Data
import tv.pouyaam.network.model.price.ResponsePrice
import tv.pouyaam.transformation.coinbase.price.PriceTransformation

class PriceTransformationImpl(private val dataTransformation: DataTransformation) : PriceTransformation(dataTransformation) {
    override fun transform(response: ResponsePrice): ResponsePriceDomain =
        ResponsePriceDomain(
            dataTransformation.transform(response.data ?: Data())
        )
}