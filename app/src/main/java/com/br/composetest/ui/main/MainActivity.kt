package com.br.composetest.ui.main

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.br.commom.ui.bases.BaseActivity
import com.br.commom.ui.components.DefaultSurface
import com.br.commom.ui.components.NormalText
import com.br.commom.ui.theme.ComposeTestTheme
import com.br.commom.ui.progressBar.InfinityProgressBar
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity() {

    private val viewModel by viewModel<MainViewModel>()

    override fun init() {
        viewModel.teste()
        view()
        observers()
    }

    private fun view() {
        setView {
            val navController = rememberNavController()

            Navigation(navController = navController)

        }
    }

    private fun observers() {
        viewModel.loadingProgressBar.observe(this) {
            //showLoading(show = it)
        }
    }

}

@Composable
private fun Navigation(navController: NavHostController) {
    NavHost(navController, startDestination = "main") {
        composable("main") { Main(navController) }
        composable("login") { Main(navController) }
        composable("progressBar") { InfinityProgressBar() }
    }
}

@Composable
private fun Main(navController: NavHostController) {
    Column {
        LazyColumn {
            items(2) {
                NormalText("Android")
            }
        }
        Button(onClick = { navController.navigate("progressBar") }) {
            Text(text = "teste")
        }
    }

}


@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
fun DefaultPreview() {
    ComposeTestTheme {
        DefaultSurface {
            Column {
                NormalText("Android")
                NormalText("Android")
                NormalText("Android")
                NormalText("Android")
                NormalText("Android")
                NormalText("Android")
                NormalText("Android")
                NormalText("Android")
                NormalText("Android")
                NormalText("Android")
                NormalText("Android")
                NormalText("Android")
                NormalText("Android")
                NormalText("Android")
                NormalText("Android")
                NormalText("Android")
                NormalText("Android")
                NormalText("Android43434343434434343")
                NormalText("Android43434343434434343")
                NormalText("Android43434343434434343")
                NormalText("Android43434343434434343")
                NormalText("Android43434343434434343")
                NormalText("Android43434343434434343")
                NormalText("Android43434343434434343")
                NormalText("Android43434343434434343")
                NormalText("Android43434343434434343")
                NormalText("Android43434343434434343")
                NormalText("Android43434343434434343")
                NormalText("Android43434343434434343")
                NormalText("Android43434343434434343")
                NormalText("Android43434343434434343")
                NormalText("Android43434343434434343")
                NormalText("Android43434343434434343")
                NormalText("Android")
            }
            InfinityProgressBar()
        }
    }
}