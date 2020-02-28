package tv.pouyaam.bottrader.domain.di.coinbase.price

import org.koin.dsl.module
import tv.pouyaam.bottrader.domain.transformation.coinbase.price.DataTransformation
import tv.pouyaam.bottrader.domain.transformation.coinbase.price.DataTransformationImpl
import tv.pouyaam.bottrader.domain.transformation.coinbase.price.PriceTransformation
import tv.pouyaam.bottrader.domain.transformation.coinbase.price.PriceTransformationImpl
import tv.pouyaam.bottrader.domain.usecase.coinbase.price.PriceUseCase

val priceDomainModule = module {
    factory { PriceTransformationImpl(get()) as PriceTransformation }
    factory { DataTransformationImpl() as DataTransformation }
    factory { PriceUseCase(get(), get()) }
}