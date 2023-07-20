package com.br.composetest.di

import org.koin.core.module.Module

object AllModules {
    val allModules = mutableListOf<Module>().apply {
        addAll(AppModule.modules)
        addAll(com.br.commom.di.AppModule.modules)
    }
}