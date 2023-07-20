package com.br.composetest.ui.login

import com.br.commom.ui.bases.BaseViewModel
import com.br.composetest.domain.models.Login
import com.br.composetest.infra.business.LoginBusiness
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class LoginScreenViewModel(
    private val loginBusiness: LoginBusiness
) : BaseViewModel<LoginScreenAction>() {

    private val _state = MutableStateFlow(LoginScreenState())
    val state = _state.asStateFlow()

    override fun handleAction(action: LoginScreenAction) {
        when (action) {
            is LoginScreenAction.Login -> login(action)
            is LoginScreenAction.ResetState -> resetState()
        }
    }

    private fun login(action: LoginScreenAction.Login) {
        val login = Login(email = action.email, password = action.password)
        asyncFlowTask(
            showLoading = true,
            flowAction = loginBusiness.loginIsValid(login),
            successAction = {
                if (it) {
                    navigationTo(LoginScreenNavigation.Home)
                }
            },
            errorAction = {
                _state.update { it.setError() }
            }
        )
    }

    private fun navigationTo(navigation: LoginScreenNavigation) = _state.update {
        when (navigation) {
            LoginScreenNavigation.Home -> it.setNavigation(LoginScreenNavigation.Home)
        }
    }

    private fun resetState() = _state.update { it.resetState() }

}