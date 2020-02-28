package tv.pouyaam.bottrader.repository.cryptocompare.historical.daily

import tv.pouyaam.bottrader.network.model.cryptocompare.historical.RequestHistorical
import tv.pouyaam.bottrader.network.model.cryptocompare.historical.daily.ResponseHistoricalDaily
import tv.pouyaam.bottrader.repository.Repository

abstract class HistoricalRepositoryDaily : Repository<RequestHistorical, ResponseHistoricalDaily>