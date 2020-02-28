package tv.pouyaam.bottrader.ui.main.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import tv.pouyaam.bottrader.domain.transformation.coinbase.price.DataTransformation
import tv.pouyaam.bottrader.domain.transformation.coinbase.price.DataTransformationImpl
import tv.pouyaam.bottrader.domain.transformation.coinbase.price.PriceTransformation
import tv.pouyaam.bottrader.domain.transformation.coinbase.price.PriceTransformationImpl
import tv.pouyaam.bottrader.domain.usecase.coinbase.price.PriceUseCase
import tv.pouyaam.bottrader.ui.main.activity.MainViewModel

val moduleMainActivity = module {
    viewModel { MainViewModel(get(), get()) }
}