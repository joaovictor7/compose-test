package com.br.composetest.ui.main

import androidx.lifecycle.ViewModel
import com.br.commom.ui.bases.BaseViewModel
import kotlinx.coroutines.delay

class MainViewModel: ViewModel() {

//    fun teste() {
//        asyncTask(showLoading = true) {
//            teste1()
//        }
//        println("fora")
//    }

    private suspend fun teste1() {
        for (i in 1..5) {
            println("testedentro")
            delay(1500)
        }
    }

}