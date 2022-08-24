package com.br.commom.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.br.commom.domain.destinations.ProgressBar
import com.br.commom.domain.interfaces.ScreenDestination

@Composable
fun DefaultNavigation(
    navController: NavHostController,
    startDestination: String,
    vararg screens: ScreenDestination
) {
    NavHost(navController, startDestination) {
        composable(route = ProgressBar.route, content = ProgressBar.screen)
        screens.forEach { screen ->
            composable(route = screen.route, content = screen.screen)
        }
    }
}