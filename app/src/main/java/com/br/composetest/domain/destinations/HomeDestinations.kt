package com.br.composetest.domain.destinations

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import com.br.commom.domain.interfaces.ScreenDestination
import com.br.composetest.ui.main.Main
import org.koin.androidx.compose.get

object Home : ScreenDestination {
    override val icon = Icons.Filled.Home
    override val route = "home"
    override val screen: @Composable () -> Unit = { Main(get()) }
}

object Profile : ScreenDestination {
    override val icon = Icons.Filled.Person
    override val route = "profile"
    override val screen: @Composable () -> Unit = { Main(get()) }
}