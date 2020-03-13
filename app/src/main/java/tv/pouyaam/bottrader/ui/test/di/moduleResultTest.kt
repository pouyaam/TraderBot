package tv.pouyaam.bottrader.ui.test.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import tv.pouyaam.bottrader.ui.test.view.ViewModelResultTest

val moduleResultTest = module {
    viewModel { ViewModelResultTest() }
}