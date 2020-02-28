package tv.pouyaam.bottrader.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.lang.reflect.ParameterizedType


abstract class ActivityBase<BINDING : ViewDataBinding, VIEWMODEL: ViewModel> : AppCompatActivity() {
    protected lateinit var binding: BINDING

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, getViewId())
        bindViewModel()
        viewModelBinded()
    }

    abstract fun getViewId() : Int
    abstract fun bindViewModel()
    abstract fun viewModelBinded()
}