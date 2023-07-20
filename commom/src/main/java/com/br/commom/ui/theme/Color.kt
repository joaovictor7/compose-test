package com.br.commom.ui.theme

import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)
val Grey200 = Color(0xFFEEEEEE)
val Grey400 = Color(0xFFBDBDBD)
val Grey900 = Color(0xFF212121)
val White = Color(0xFFFFFFFF)
val Black = Color(0xFF000000)

val DarkColorsTheme = darkColors(
    primary = Purple500,
    primaryVariant = Purple700,
    secondary = Teal200,
    background = Grey900,
    onBackground = Black
)

val LightColorsTheme = lightColors(
    primary = Purple200,
    primaryVariant = Purple700,
    secondary = Teal200,
    background = Grey200,
    onBackground = Grey900

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)
