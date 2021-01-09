package com.dixitpatel.rightmovedemo.ui.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.dixitpatel.rightmovedemo.model.PropertiesResponse
import com.dixitpatel.rightmovedemo.network.APIRequestResponseHandler
import kotlinx.coroutines.Dispatchers

abstract class LiveCoroutinesViewModel : ViewModel() {

  inline fun <T> launchOnViewModelScope(crossinline block: suspend () -> LiveData<T>): LiveData<T> {
    return liveData(viewModelScope.coroutineContext + Dispatchers.IO) {

      emitSource(block())
    }
  }
}
