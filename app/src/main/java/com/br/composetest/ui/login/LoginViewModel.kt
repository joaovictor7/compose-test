package com.br.composetest.ui.login

import com.br.commom.ui.bases.BaseViewModel


class LoginViewModel : BaseViewModel() {

    fun teste() {
        asyncTask(showLoading = true) {
            teste1()
        }
        println("fora")
    }

    private suspend fun teste1() {
        for (i in 1..5) {
            println("testedentro")
        }
    }

}