package tv.pouyaam.bottrader.ui.price.view

import android.util.Log
import androidx.lifecycle.observe
import kotlinx.android.synthetic.main.fragment_price.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.ta4j.core.*
import org.ta4j.core.analysis.criteria.TotalProfitCriterion
import org.ta4j.core.indicators.EMAIndicator
import org.ta4j.core.indicators.MACDIndicator
import org.ta4j.core.indicators.StochasticOscillatorKIndicator
import org.ta4j.core.indicators.helpers.ClosePriceIndicator
import org.ta4j.core.trading.rules.OverIndicatorRule
import org.ta4j.core.trading.rules.UnderIndicatorRule
import tv.pouyaam.bottrader.R
import tv.pouyaam.bottrader.databinding.FragmentPriceBinding
import tv.pouyaam.bottrader.domain.model.cryptocompare.historical.daily.DataItemDomain
import tv.pouyaam.bottrader.ui.base.FragmentBase
import java.time.Duration
import java.time.Instant
import java.time.ZoneId
import java.time.ZonedDateTime

@ExperimentalCoroutinesApi
class FragmentPrice : FragmentBase<FragmentPriceBinding, PriceViewModel>() {
    private val viewModel: PriceViewModel by viewModel()
    override fun getViewId(): Int = R.layout.fragment_price

    override fun bindViewModel() {
        binding.viewModel = viewModel
    }

    override fun viewModelBinded() {
        binding.viewModel?.loading?.observe(this) {
            if (it) btc_price.text = "Loading..."
        }

        binding.viewModel?.error?.observe(this) {
            //            btc_price.text = "${it}"
        }

        binding.viewModel?.btcPrice?.observe(this) {
            btc_price.text = "${it.dataDomain.amount} ${it.dataDomain.currency}"
        }
//
//        binding.viewModel?.btcMonthPrice?.observe(this) {
//            rsiStrats(it.dataDomain.data)
//        }
    }

    private fun rsiStrats(data: List<DataItemDomain>) {

        val bars = data.map {

            val beginTime = ZonedDateTime.ofInstant(
                Instant.ofEpochMilli(it.time.toLong() * 1000),
                ZoneId.systemDefault()
            )
            val endTime = beginTime.plusDays(1)

            BaseBar(
                Duration.ofSeconds(86400),
                endTime,
                it.open,
                it.high,
                it.low,
                it.close,
                it.volumefrom
            )
        }
        Log.d("DEBUG_MAIN", "BARS= ${bars}")
        val series = BaseBarSeries(bars)
        val strategy = buildStrategy(series)

        // Running the strategy
        // Running the strategy
        val seriesManager = BarSeriesManager(series)
        val tradingRecord = seriesManager.run(strategy)
        Log.d("DEBUG_MAIN", "Number of trades for the strategy: " + tradingRecord.tradeCount)

        // Analysis
        // Analysis
        Log.d(
            "DEBUG_MAIN",
            "Total profit for the strategy: " + TotalProfitCriterion().calculate(
                series,
                tradingRecord
            )
        )

        btc_price.text =
            "Number of trades for the strategy: ${tradingRecord.tradeCount}\n total profit for the strategy: ${TotalProfitCriterion().calculate(
                series,
                tradingRecord
            )}"
    }

    fun buildStrategy(series: BarSeries): Strategy? {
        val closePrice = ClosePriceIndicator(series)

        // The bias is bullish when the shorter-moving average moves above the longer
        // moving average.
        // The bias is bearish when the shorter-moving average moves below the longer
        // moving average.
        // The bias is bullish when the shorter-moving average moves above the longer
        // moving average.
        // The bias is bearish when the shorter-moving average moves below the longer
        // moving average.
        val shortEma = EMAIndicator(closePrice, 9)
        val longEma = EMAIndicator(closePrice, 26)

        val stochasticOscillK =
            StochasticOscillatorKIndicator(series, 14)

        val macd = MACDIndicator(closePrice, 9, 26)
        val emaMacd = EMAIndicator(macd, 18)

        // Entry rule
        // Entry rule
        val entryRule = OverIndicatorRule(shortEma, longEma) // Trend


        // Exit rule
        // Exit rule
        val exitRule = UnderIndicatorRule(shortEma, longEma) // Trend



        return BaseStrategy(entryRule, exitRule)
    }
}

//
