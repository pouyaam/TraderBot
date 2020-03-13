package tv.pouyaam.bottrader.navigation.di

import org.koin.dsl.module
import tv.pouyaam.bottrader.navigation.result.NavResultHandler
import tv.pouyaam.bottrader.navigation.result.NavResultHandlerImpl

val navigationModule = module {
    single { NavResultHandlerImpl() as NavResultHandler }
}