package com.br.composetest.domain.destinations

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import com.br.commom.domain.interfaces.ScreenDestination
import com.br.composetest.ui.home.HomeScreen
import com.br.composetest.ui.home.HomeScreenParam

object Home : ScreenDestination() {
    private const val ROUTE = "home"

    override val icon = Icons.Filled.Home
    override val route = ROUTE
    override val screen =
        @Composable { _: NavHostController, navBackStackEntry: NavBackStackEntry ->
            val param = navBackStackEntry.getParam<HomeScreenParam>()
            HomeScreen(param)
        }
}

object Profile : ScreenDestination() {
    private const val ROUTE = "profile"

    override val icon = Icons.Filled.Person
    override val route = ROUTE
    override val screen = @Composable { _: NavHostController, _: NavBackStackEntry ->
        HomeScreen(null)
    }
}