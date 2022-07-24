package com.br.composetest.ui.main

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.br.commom.ui.bases.BaseActivity
import com.br.commom.ui.components.NormalText
import com.br.commom.ui.theme.ComposeTestTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity() {

    private val viewModel by viewModel<MainViewModel>()

    override fun init() {
        setView()
    }

    private fun setView() {
        setView {
            LazyColumn {
                items(2) {
                    NormalText("Android")
                }
            }
        }
    }

}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeTestTheme {
        NormalText("Android")
    }
}