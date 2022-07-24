package com.br.commom.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun ComposeTestTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    MaterialTheme(
        colors = if (darkTheme) DarkColorsTheme else LightColorsTheme,
        typography = if (darkTheme) DarkTypographyTheme else LightTypographyTheme,
        shapes = Shapes,
        content = content
    )
}
