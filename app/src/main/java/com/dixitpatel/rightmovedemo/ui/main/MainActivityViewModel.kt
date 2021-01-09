package com.dixitpatel.rightmovedemo.ui.main

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.*
import com.dixitpatel.rightmovedemo.R
import com.dixitpatel.rightmovedemo.application.MyApplication
import com.dixitpatel.rightmovedemo.model.Property
import com.dixitpatel.rightmovedemo.network.ApiInterface
import com.dixitpatel.rightmovedemo.repository.MainViewRepository
import com.dixitpatel.rightmovedemo.ui.base.LiveCoroutinesViewModel
import timber.log.Timber
import javax.inject.Inject

/**
 *  Main Activity ViewModel : ViewModel
 */
class MainActivityViewModel @Inject constructor(val apiInterface: ApiInterface, val mainViewRepository: MainViewRepository) : LiveCoroutinesViewModel()
{
    var propertyListLiveData: LiveData<List<Property?>>

    var calculateAverage = MutableLiveData("")


    private val _toastLiveData: MutableLiveData<String> = MutableLiveData()
    val toastLiveData: LiveData<String> get() = _toastLiveData

    val isLoading: ObservableBoolean = ObservableBoolean(false)

    init
    {
        Timber.d("init MainViewModel")
        isLoading.set(true)
            propertyListLiveData = launchOnViewModelScope {
                this.mainViewRepository.propertyApiCall(apiInterface = apiInterface,
                    onSuccess = {
                        isLoading.set(false)
                    },
                    onError = {

                        isLoading.set(false)
                        if(it!!.contains("UnknownHostException"))
                        {
                            _toastLiveData.postValue(MyApplication.instance.getString(R.string.internet_not_available))
                        }else
                        {
                            _toastLiveData.postValue(it)
                        }

                    }
                ).asLiveData()
            }
    }
}