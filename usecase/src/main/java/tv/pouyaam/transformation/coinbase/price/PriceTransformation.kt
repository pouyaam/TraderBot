package tv.pouyaam.transformation.coinbase.price

import tv.pouyaam.model.price.ResponsePriceDomain
import tv.pouyaam.network.model.price.ResponsePrice
import tv.pouyaam.transformation.Transformation

abstract class PriceTransformation(private val dataTransformation: DataTransformation) : Transformation<ResponsePrice, ResponsePriceDomain>