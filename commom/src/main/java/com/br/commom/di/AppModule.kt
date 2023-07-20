package com.br.commom.di

import org.koin.dsl.module

object AppModule {
    val modules by lazy {
        listOf(viewModelModules)
    }

    private val viewModelModules = module {
    }

}
