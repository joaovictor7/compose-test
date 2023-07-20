package com.br.composetest.ui.home

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.br.commom.ui.components.DefaultSurface
import com.br.commom.ui.components.NormalText
import com.br.commom.ui.theme.ComposeTestTheme

@Composable
fun HomeScreen(
    param: HomeScreenParam?
) {
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
            HomeScreen(null)
        }
    }
}