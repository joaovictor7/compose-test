package com.br.commom.ui.bases

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*
import java.lang.Exception

open class BaseViewModel: ViewModel() {

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
            try {
                onAction.invoke()
            } catch (e: Exception) {
                onError.invoke(e)
            }
        }
    }


    private fun handleError(e: Exception) {

    }

}