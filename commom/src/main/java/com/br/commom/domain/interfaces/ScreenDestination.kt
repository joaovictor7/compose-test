package com.br.commom.domain.interfaces

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

interface ScreenDestination {
    val icon: ImageVector
    val route: String
    val screen: @Composable () -> Unit
}