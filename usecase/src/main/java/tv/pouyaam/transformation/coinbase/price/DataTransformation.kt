package tv.pouyaam.transformation.coinbase.price

import tv.pouyaam.model.price.DataDomain
import tv.pouyaam.network.model.price.Data
import tv.pouyaam.transformation.Transformation

abstract class DataTransformation : Transformation<Data, DataDomain>