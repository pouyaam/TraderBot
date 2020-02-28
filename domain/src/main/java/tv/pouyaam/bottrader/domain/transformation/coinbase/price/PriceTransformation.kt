package tv.pouyaam.bottrader.domain.transformation.coinbase.price

import tv.pouyaam.bottrader.domain.model.coinbase.price.ResponsePriceDomain
import tv.pouyaam.bottrader.network.model.coinbase.price.ResponsePrice
import tv.pouyaam.transformation.Transformation

abstract class PriceTransformation(private val dataTransformation: DataTransformation) :
    Transformation<ResponsePrice, ResponsePriceDomain>