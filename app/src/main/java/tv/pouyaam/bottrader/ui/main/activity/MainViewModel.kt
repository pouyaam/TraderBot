package tv.pouyaam.bottrader.ui.main.activity

import androidx.lifecycle.*
import kotlinx.coroutines.*
import tv.pouyaam.bottrader.domain.model.coinbase.price.CurrencyEnum
import tv.pouyaam.bottrader.domain.model.coinbase.price.ResponsePriceDomain
import tv.pouyaam.bottrader.domain.model.cryptocompare.historical.daily.ResponseHistoricalDailyDomain
import tv.pouyaam.bottrader.domain.usecase.coinbase.price.PriceUseCase
import tv.pouyaam.bottrader.domain.usecase.cryptocompare.historical.daily.HistoricalDailyUseCase
import tv.pouyaam.bottrader.network.model.cryptocompare.historical.RequestHistorical

class MainViewModel(
    private val priceUseCase: PriceUseCase,
    private val historicalDailyUseCase: HistoricalDailyUseCase
): ViewModel() {
    private val _btcPrice: MutableLiveData<ResponsePriceDomain> = MutableLiveData()
    val btcPrice: LiveData<ResponsePriceDomain> = _btcPrice

    private val _btcMonthPrice: MutableLiveData<ResponseHistoricalDailyDomain> = MutableLiveData()
    val btcMonthPrice: LiveData<ResponseHistoricalDailyDomain> = _btcMonthPrice


    private val _loading: MutableLiveData<Boolean> = MutableLiveData()
    var loading: LiveData<Boolean> = _loading

    private val _error: MutableLiveData<Throwable> = MutableLiveData()
    var error: LiveData<Throwable> = _error

    init {
        fetchBtcPrice()
        fetchLastMonthPrice()
    }

    fun fetchBtcPrice() = viewModelScope.launch(Dispatchers.Main) {
        priceUseCase.execute(CurrencyEnum.USD.toString()) {
            onStart = { _loading.value = true }

            onComplete = {
                _loading.value = false
                _btcPrice.value = it
            }

            onError = { _loading.value = false }
        }
    }

    fun fetchLastMonthPrice() = viewModelScope.launch(Dispatchers.Main) {
        historicalDailyUseCase.execute(
            RequestHistorical("BTC", CurrencyEnum.USD.toString(), 30)
        ) {
            onStart = { _loading.value = true }

            onComplete = {
                _btcMonthPrice.value = it
            }

            onError = { _loading.value = false }
        }
    }
}