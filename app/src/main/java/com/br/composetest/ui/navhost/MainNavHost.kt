package com.br.composetest.ui.navhost

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.br.commom.ui.progressbar.InfinityProgressBar
import com.br.composetest.ui.login.LoginScreen
import com.br.composetest.ui.main.Main
import org.koin.androidx.compose.get

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController, startDestination = "main") {
        composable("main") { Main(navController, get()) }
        composable("login") { LoginScreen(navController, get()) }
        composable("progressBar") { InfinityProgressBar(navController) }
    }
}