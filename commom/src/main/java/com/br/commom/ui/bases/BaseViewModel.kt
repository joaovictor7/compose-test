package com.br.commom.ui.bases

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*
import java.lang.Exception

open class BaseViewModel: ViewModel() {

    val _loadingProgressBar = MutableLiveData<Boolean>()
    val loadingProgressBar: LiveData<Boolean> = _loadingProgressBar

    protected fun asyncTask(
        showLoading: Boolean = false,
        onError: (e: Exception) -> Unit = ::handleError,
        onAction: suspend () -> Unit
    ) {
//        return flow<Unit> {
//            onAction.invoke()
//        }.onStart {
//            showLoading(showLoading)
//        }.onCompletion {
//            showLoading(false)
//        }.catch {
//            onError.invoke(it)
//        }

        viewModelScope.launch {
            showLoading(showLoading)
            try {
                onAction.invoke()
            } catch (e: Exception) {
                onError.invoke(e)
            }
            showLoading(false)
        }
    }

    private fun showLoading(show: Boolean) {
        _loadingProgressBar.postValue(show)
    }

    private fun handleError(e: Exception) {

    }

}