package com.br.commom.ui.bases

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.br.commom.ui.components.DefaultSurface
import com.br.commom.ui.progressBar.InfinityProgressBar
import com.br.commom.ui.theme.ComposeTestTheme

abstract class BaseActivity : ComponentActivity() {

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

    @Composable
    protected fun showLoading(show: Boolean) {
        InfinityProgressBar()
        if (show) {

        }


    }

    protected abstract fun init()

}