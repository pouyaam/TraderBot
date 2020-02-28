package tv.pouyaam.bottrader.domain.transformation.cryptocompare.historical

import tv.pouyaam.bottrader.domain.model.cryptocompare.historical.daily.DataDomain
import tv.pouyaam.bottrader.network.model.cryptocompare.historical.daily.Data
import tv.pouyaam.transformation.Transformation

abstract class DataTransformation : Transformation<Data, DataDomain>