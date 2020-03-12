package tv.pouyaam.bottrader.ui.price.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import tv.pouyaam.bottrader.ui.price.view.PriceViewModel

val moduleFragmentPrice = module {
    viewModel { PriceViewModel(get(), get()) }
}