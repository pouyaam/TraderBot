package tv.pouyaam.bottrader.domain.transformation.coinbase.price

import tv.pouyaam.bottrader.domain.model.coinbase.price.ResponsePriceDomain
import tv.pouyaam.bottrader.network.model.coinbase.price.Data
import tv.pouyaam.bottrader.network.model.coinbase.price.ResponsePrice

class PriceTransformationImpl(private val dataTransformation: DataTransformation) : PriceTransformation(dataTransformation) {
    override fun transform(response: ResponsePrice): ResponsePriceDomain =
        ResponsePriceDomain(
            dataTransformation.transform(response.data ?: Data())
        )
}