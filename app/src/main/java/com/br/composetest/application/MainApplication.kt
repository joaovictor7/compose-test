package com.br.composetest.application

import android.app.Application
import com.br.composetest.di.AppModule.allModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin()
    }

    private fun startKoin() {
        startKoin {
            androidContext(this@MainApplication)
            androidLogger()
            modules(allModules)
        }
    }

}