package tv.pouyaam.bottrader.domain.transformation.coinbase.price

import tv.pouyaam.bottrader.domain.model.coinbase.price.DataDomain
import tv.pouyaam.bottrader.network.model.coinbase.price.Data
import tv.pouyaam.transformation.Transformation

abstract class DataTransformation : Transformation<Data, DataDomain>