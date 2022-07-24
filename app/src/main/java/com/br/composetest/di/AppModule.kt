package com.br.composetest.di

import com.br.composetest.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.Module
import org.koin.dsl.module

object AppModule {
    private val modules by lazy {
        listOf(viewModelModules)
    }

    private val viewModelModules = module {
        viewModelOf(::MainViewModel)
    }

    val allModules = mutableListOf<Module>().apply {
        addAll(modules)
    }

}
