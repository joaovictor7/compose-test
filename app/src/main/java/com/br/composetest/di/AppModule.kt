package com.br.composetest.di

import com.br.composetest.infra.business.LoginBusiness
import com.br.composetest.infra.repositories.SafeApiCallerRepository
import com.br.composetest.infra.repositories.UserRepository
import com.br.composetest.ui.login.LoginScreenViewModel
import com.br.composetest.ui.main.MainViewModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

object AppModule {
    val modules by lazy {
        listOf(viewModelModules, repositoryModules, businessModules)
    }

    private val viewModelModules = module {
        viewModelOf(::MainViewModel)
        viewModel { LoginScreenViewModel(loginBusiness = get()) }
    }

    private val businessModules = module {
        factory { LoginBusiness(userRep = get()) }
    }

    private val repositoryModules = module {
        factory { SafeApiCallerRepository() }

        factory {
            UserRepository(
                safeAppCallerRepository = get(),
                firebaseAuth = Firebase.auth
            )
        }
    }
}