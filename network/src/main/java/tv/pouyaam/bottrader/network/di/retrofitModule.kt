package tv.pouyaam.bottrader.network.di

import org.koin.core.qualifier.named
import org.koin.dsl.module
import tv.pouyaam.bottrader.network.interceptor.cryptocompare.ApiKeyInterceptor
import tv.pouyaam.bottrader.network.retrofit.RetrofitProvider
import tv.pouyaam.bottrader.network.retrofit.coinbase.CoinbaseRetrofitProviderImpl
import tv.pouyaam.bottrader.network.retrofit.cryptocompare.CryptoCompareRetrofitProviderImpl

const val CRYPTO_COMPARE = "CRYPTO_COMPARE"
const val COINBASE = "COINBASE"

val retrofitModule = module {
    single { ApiKeyInterceptor() }
    single(named(CRYPTO_COMPARE)) { CryptoCompareRetrofitProviderImpl(get()) as RetrofitProvider }
    single(named(COINBASE)) { CoinbaseRetrofitProviderImpl() as RetrofitProvider }
}