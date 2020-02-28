package tv.pouyaam.bottrader.network.di

import org.koin.core.qualifier.named
import org.koin.dsl.module
import tv.pouyaam.bottrader.network.api.coinbase.PriceApi
import tv.pouyaam.bottrader.network.api.cryptocompare.HistoricalApi
import tv.pouyaam.bottrader.network.retrofit.RetrofitProvider

val apiModule = module {
    //Coinbase
    single { get<RetrofitProvider>(named(COINBASE)).provideRetrofit().create(PriceApi::class.java) }

    //CryptoCompare
    single { get<RetrofitProvider>(named(CRYPTO_COMPARE)).provideRetrofit().create(HistoricalApi::class.java) }
}