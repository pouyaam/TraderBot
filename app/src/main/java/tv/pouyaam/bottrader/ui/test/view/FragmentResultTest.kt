package tv.pouyaam.bottrader.ui.test.view

import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.fragment_test_result.*
import kotlinx.coroutines.FlowPreview
import org.koin.androidx.viewmodel.ext.android.viewModel
import tv.pouyaam.bottrader.R
import tv.pouyaam.bottrader.databinding.FragmentTestResultBinding
import tv.pouyaam.bottrader.navigation.domain.NavResultDomain
import tv.pouyaam.bottrader.ui.base.FragmentBase
import tv.pouyaam.bottrader.ui.base.ViewModelBase

@FlowPreview
class FragmentResultTest : FragmentBase<FragmentTestResultBinding, ViewModelResultTest>(), ContractResultTest {
    private val viewModelResultTest: ViewModelResultTest by viewModel()
    override fun getViewId(): Int = R.layout.fragment_test_result

    override fun onBinding() : ViewModelBase {
        binding.viewModel = viewModelResultTest
        binding.contract = this

        return viewModelResultTest
    }

    override fun onBindingFinished() {

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        result.setOnClickListener { popWithResult("TEST", "TEST ${System.currentTimeMillis() % 10000}") }
    }

    override fun onResult(navResultDomain: NavResultDomain) {}

}