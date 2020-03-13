@file:Suppress("UNCHECKED_CAST")

package tv.pouyaam.bottrader.ui.price.view

import androidx.lifecycle.*
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.flow.*
import tv.pouyaam.bottrader.common.ktx.launchInScopeAndOnEach
import tv.pouyaam.bottrader.domain.model.coinbase.price.CurrencyEnum
import tv.pouyaam.bottrader.domain.model.coinbase.price.ResponsePriceDomain
import tv.pouyaam.bottrader.domain.model.cryptocompare.historical.daily.ResponseHistoricalDailyDomain
import tv.pouyaam.bottrader.domain.usecase.coinbase.price.PriceUseCase
import tv.pouyaam.bottrader.domain.usecase.cryptocompare.historical.daily.HistoricalDailyUseCase
import tv.pouyaam.bottrader.navigation.domain.NavResultDomain
import tv.pouyaam.bottrader.navigation.result.NavResultHandler
import tv.pouyaam.bottrader.network.model.cryptocompare.historical.RequestHistorical
import tv.pouyaam.bottrader.ui.base.ViewModelBase

@ExperimentalCoroutinesApi
class ViewModelPrice(
    private val priceUseCase: PriceUseCase,
    private val historicalDailyUseCase: HistoricalDailyUseCase
): ViewModelBase() {
    private val _btcPrice: MutableLiveData<ResponsePriceDomain> = MutableLiveData()
    val btcPrice: LiveData<ResponsePriceDomain> = _btcPrice

    private val _btcMonthPrice: MutableLiveData<ResponseHistoricalDailyDomain> = MutableLiveData()
    val btcMonthPrice: LiveData<ResponseHistoricalDailyDomain> = _btcMonthPrice

    private val _loading: MutableLiveData<Boolean> = MutableLiveData()
    var loading: LiveData<Boolean> = _loading

    private val _error: MutableLiveData<Throwable> = MutableLiveData()
    var error: LiveData<Throwable> = _error

    init {
        fetchLastMonthPrice()
    }

    fun fetchBtcPrice() = viewModelScope.launch(Dispatchers.Main) {
        priceUseCase
            .execute(CurrencyEnum.USD.toString())
            .launchInScopeAndOnEach(this,
                startAction = { _loading.value = true },
                action = {
                    _loading.value = false
                    _btcPrice.value = it
                }
            )
    }

    fun fetchLastMonthPrice() = viewModelScope.launch(Dispatchers.Main) {
        historicalDailyUseCase.execute(
            RequestHistorical("BTC", CurrencyEnum.USD.toString(), 30)
        ).launchInScopeAndOnEach(this,
            startAction = { _loading.value = true },
            action = {
                _loading.value = false
                _btcMonthPrice.value = it
            }
        )
    }
}

