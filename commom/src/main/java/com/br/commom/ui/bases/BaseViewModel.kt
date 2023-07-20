package com.br.commom.ui.bases

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

abstract class BaseViewModel<Action> : ViewModel() {
    abstract fun handleAction(action: Action)

    protected fun <T> asyncFlowTask(
        showLoading: Boolean = false,
        flowAction: Flow<T>,
        successAction: (param: T) -> Unit,
        errorAction: (e: Throwable) -> Unit = ::handleError
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            flowAction.onStart {
                //showLoading(showLoading)
            }.onCompletion {
                //showLoading(false)
            }.catch {
                errorAction.invoke(it)
            }.collect {
                successAction.invoke(it)
            }
        }
    }

    private fun handleError(e: Throwable) {

    }

}