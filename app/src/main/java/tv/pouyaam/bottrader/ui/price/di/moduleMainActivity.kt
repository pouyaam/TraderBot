package tv.pouyaam.bottrader.ui.price.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import tv.pouyaam.bottrader.ui.price.view.ViewModelPrice

val moduleFragmentPrice = module {
    viewModel { ViewModelPrice(get(), get()) }
}