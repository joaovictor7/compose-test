package com.br.composetest.ui.login

sealed class LoginScreenAction {

    object ResetState: LoginScreenAction()
    data class Login(val email: String, val password: String): LoginScreenAction()

}