package tv.pouyaam.bottrader.ui.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import tv.pouyaam.bottrader.navigation.domain.NavResultDomain

abstract class ViewModelBase : ViewModel() {

    private val _result: MutableLiveData<NavResultDomain> = MutableLiveData()
    val result: LiveData<NavResultDomain> = _result

    fun result(navResultDomain: NavResultDomain) = viewModelScope.launch {
        _result.postValue(navResultDomain)
    }
}