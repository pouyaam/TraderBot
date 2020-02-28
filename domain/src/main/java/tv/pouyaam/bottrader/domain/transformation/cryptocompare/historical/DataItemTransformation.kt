package tv.pouyaam.bottrader.domain.transformation.cryptocompare.historical

import tv.pouyaam.bottrader.domain.model.cryptocompare.historical.daily.DataDomain
import tv.pouyaam.bottrader.domain.model.cryptocompare.historical.daily.DataItemDomain
import tv.pouyaam.bottrader.network.model.cryptocompare.historical.daily.Data
import tv.pouyaam.bottrader.network.model.cryptocompare.historical.daily.DataItem
import tv.pouyaam.transformation.Transformation

abstract class DataItemTransformation : Transformation<DataItem, DataItemDomain>