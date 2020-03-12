package tv.pouyaam.bottrader.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.lang.reflect.ParameterizedType


abstract class FragmentBase<BINDING : ViewDataBinding, VIEWMODEL: ViewModel> : Fragment() {
    protected lateinit var binding: BINDING

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, getViewId(), container, false)
        bindViewModel()
        viewModelBinded()
        return binding.root
    }

    abstract fun getViewId() : Int
    abstract fun bindViewModel()
    abstract fun viewModelBinded()
}