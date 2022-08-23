package com.br.commom.ui.bases

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.br.commom.ui.components.DefaultSurface
import com.br.commom.ui.theme.ComposeTestTheme
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

abstract class BaseActivity : ComponentActivity() {

    protected lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    protected fun setView(content: @Composable () -> Unit) {
        setContent {
            ComposeTestTheme {
                DefaultSurface {
                    content.invoke()
                }
            }
        }
    }

    protected fun showLoading(show: Boolean) {
        if (show) {
            navController.navigate("progressBar")
        } else {
            navController.popBackStack("progressBar", true)
        }

    }

    protected abstract fun init()

}