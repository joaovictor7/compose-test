package com.br.composetest.ui.login

import com.br.commom.ui.bases.BaseState

data class LoginScreenState(
    override val error: Boolean = false,
    override val loading: Boolean = false,
    val navigation: LoginScreenNavigation? = null
) : BaseState<LoginScreenState> {

    override fun resetState() = copy(navigation = null)

    fun setError() = copy(error = true, loading = false)

    fun setNavigation(navigation: LoginScreenNavigation) = copy(
        navigation = navigation
    )

}