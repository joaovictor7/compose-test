package com.br.commom.ui.bases

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.br.commom.ui.components.DefaultSurface
import com.br.commom.ui.theme.ComposeTestTheme

abstract class BaseActivity : ComponentActivity() {

    protected lateinit var navController: NavHostController

    protected fun setScreen(content: @Composable () -> Unit) {
        setContent {
            ComposeTestTheme {
                DefaultSurface {
                    content.invoke()
                }
            }
        }
    }

}