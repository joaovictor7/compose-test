package com.br.commom.domain.interfaces

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavBackStackEntry

interface ScreenDestination {
    val icon: ImageVector
    val route: String
    val screen: @Composable (NavBackStackEntry) -> Unit
}