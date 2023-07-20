package com.br.composetest.domain.destinations

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import com.br.commom.domain.interfaces.ScreenDestination
import com.br.composetest.ui.login.LoginScreen

object Login : ScreenDestination() {
    private const val ROUTE = "login"

    override val icon = Icons.Filled.Home
    override val route = ROUTE
    override val screen =
        @Composable { navHostController: NavHostController, _: NavBackStackEntry ->
            LoginScreen(navHostController)
        }
}