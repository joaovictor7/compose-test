package com.br.commom.domain.destinations

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import com.br.commom.domain.interfaces.ScreenDestination
import com.br.commom.ui.components.InfinityProgressBar

object ProgressBar : ScreenDestination() {
    override val icon = Icons.Filled.Person
    override val route = "infinityProgressBar"

    //override val arguments: List<NamedNavArgument> = emptyList()
    override val screen: @Composable (NavHostController, NavBackStackEntry) -> Unit = { navHostController: NavHostController, navBackStackEntry: NavBackStackEntry -> InfinityProgressBar() }
}