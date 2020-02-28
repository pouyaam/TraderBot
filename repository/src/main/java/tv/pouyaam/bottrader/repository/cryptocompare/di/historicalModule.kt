package tv.pouyaam.bottrader.repository.cryptocompare.di

import org.koin.dsl.module
import tv.pouyaam.bottrader.repository.cryptocompare.historical.daily.HistoricalRepositoryDaily
import tv.pouyaam.bottrader.repository.cryptocompare.historical.daily.HistoricalRepositoryDailyImpl

val historicalModule = module {
    factory { HistoricalRepositoryDailyImpl(get()) as HistoricalRepositoryDaily }
}
