package com.br.commom.ui.bases

interface BaseState<State> {

    val error: Boolean
    val loading: Boolean

    fun resetState(): State

}