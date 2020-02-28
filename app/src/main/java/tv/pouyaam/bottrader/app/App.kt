package tv.pouyaam.bottrader.app

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import tv.pouyaam.bottrader.domain.di.coinbase.price.priceDomainModule
import tv.pouyaam.bottrader.domain.di.cryptocompare.historical.historicalDomainModule
import tv.pouyaam.bottrader.network.di.apiModule
import tv.pouyaam.bottrader.network.di.retrofitModule
import tv.pouyaam.bottrader.repository.coinbase.di.priceRepositoryModule
import tv.pouyaam.bottrader.repository.cryptocompare.di.historicalModule
import tv.pouyaam.bottrader.ui.main.di.moduleMainActivity

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    retrofitModule,
                    apiModule,
                    priceRepositoryModule,
                    priceDomainModule,
                    historicalModule,
                    historicalDomainModule,
                    moduleMainActivity
                )
            )
        }
    }
}