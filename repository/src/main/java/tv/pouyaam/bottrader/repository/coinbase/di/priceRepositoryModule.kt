package tv.pouyaam.bottrader.repository.coinbase.di

import org.koin.dsl.module
import tv.pouyaam.bottrader.repository.coinbase.price.PriceRepository
import tv.pouyaam.bottrader.repository.coinbase.price.PriceRepositoryImpl

val priceRepositoryModule = module {
    factory { PriceRepositoryImpl(get()) as PriceRepository }
}