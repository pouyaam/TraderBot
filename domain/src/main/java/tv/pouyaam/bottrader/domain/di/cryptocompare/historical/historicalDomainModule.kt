package tv.pouyaam.bottrader.domain.di.cryptocompare.historical

import org.koin.dsl.module
import tv.pouyaam.bottrader.domain.transformation.cryptocompare.historical.*
import tv.pouyaam.bottrader.domain.usecase.cryptocompare.historical.daily.HistoricalDailyUseCase

val historicalDomainModule = module {
    factory { DataItemTransformationImpl() as DataItemTransformation }
    factory { DataTransformationImpl(get()) as DataTransformation }
    factory { HistoricalDailyTransformationImpl(get()) as HistoricalDailyTransformation }
    factory { HistoricalDailyUseCase(get(), get()) }
}