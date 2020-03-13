package tv.pouyaam.bottrader.ui.base

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.observe
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import org.koin.android.ext.android.inject
import tv.pouyaam.bottrader.navigation.domain.NavResultDomain
import tv.pouyaam.bottrader.navigation.ktx.onResult
import tv.pouyaam.bottrader.navigation.result.NavResultHandler


@FlowPreview
abstract class FragmentBase<BINDING : ViewDataBinding, VIEWMODEL: ViewModelBase> : Fragment(), BaseContract {
    protected val navResultHandler: NavResultHandler by inject()
    private lateinit var viewModelBase: ViewModelBase
    protected lateinit var binding: BINDING

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, getViewId(), container, false)
        viewModelBase = onBinding()

        onBindingFinished()

        viewModelBase.result.observe(this) {
            onResult(it)
        }

        return binding.root
    }

    @ExperimentalCoroutinesApi
    override fun navigateToDirection(
        direction: NavDirections
    ) {
        findNavController().navigate(direction)
    }

    override fun popWithResult(resultOwner: String, channelName: String, payload: Any) {
        navResultHandler.sendWithMap(resultOwner, channelName, payload)
        findNavController().popBackStack()
    }

    abstract fun getViewId() : Int
    abstract fun onBinding() : ViewModelBase
    abstract fun onBindingFinished()
    abstract fun onResult(navResultDomain: NavResultDomain)
}