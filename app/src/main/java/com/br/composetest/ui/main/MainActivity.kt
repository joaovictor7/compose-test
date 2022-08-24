package com.br.composetest.ui.main

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.br.commom.domain.destinations.ProgressBar
import com.br.commom.ui.bases.BaseActivity
import com.br.commom.ui.components.DefaultSurface
import com.br.commom.ui.components.NormalText
import com.br.commom.ui.navigation.DefaultNavigation
import com.br.commom.ui.theme.ComposeTestTheme
import com.br.composetest.domain.destinations.Home
import com.br.composetest.domain.destinations.Profile
import org.koin.androidx.compose.get
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity() {

    private val viewModel by viewModel<MainViewModel>()

    override fun init() {
        observers()
        view()
    }

    private fun view() {
        setView {
            navController = rememberNavController()
            DefaultNavigation(
                navController = navController,
                startDestination = Home.route,
                screens = arrayOf(Home, Profile)
            )
        }
    }

    private fun observers() {

    }

}



@Composable
fun Main() {
    Column {
        LazyColumn {
            items(2) {
                NormalText("Android")
            }
        }
        Button(onClick = {  }) {
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
           Main()
        }
    }
}