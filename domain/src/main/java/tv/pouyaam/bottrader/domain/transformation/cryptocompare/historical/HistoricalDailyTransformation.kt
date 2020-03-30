package tv.pouyaam.bottrader.domain.transformation.cryptocompare.historical

import tv.pouyaam.bottrader.domain.model.cryptocompare.historical.daily.ResponseHistoricalDailyDomain
import tv.pouyaam.bottrader.network.model.cryptocompare.historical.daily.ResponseHistoricalDaily
import tv.pouyaam.bottrader.domain.transformation.Transformation

abstract class HistoricalDailyTransformation :
    Transformation<ResponseHistoricalDaily, ResponseHistoricalDailyDomain>