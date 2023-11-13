package com.br.composetest.ui.main

import android.os.Bundle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.br.commom.ui.bases.BaseActivity
import com.br.composetest.domain.destinations.Home
import com.br.composetest.domain.destinations.Login
import com.br.composetest.domain.destinations.Profile
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity() {

    private val viewModel by viewModel<MainViewModel>()
    private val screensList = listOf(Home, Profile, Login)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        screens()
    }

    private fun screens() {
        setScreen {
            navController = rememberNavController()
            NavHost(navController, Login.route) {
                screensList.forEach { screen ->
                    composable(
                        route = screen.routePath,
                        arguments = screen.arguments
                    ) { screen.screen.invoke(navController, it) }
                }
            }
        }
    }

}