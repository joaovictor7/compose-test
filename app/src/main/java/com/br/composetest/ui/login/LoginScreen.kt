package com.br.composetest.ui.login

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.br.commom.domain.models.Spacings
import com.br.commom.ui.components.Button
import com.br.commom.ui.components.DefaultSurface
import com.br.commom.ui.components.OutlineHiddenInput
import com.br.commom.ui.components.OutlineInput
import com.br.commom.ui.theme.ComposeTestTheme
import com.br.composetest.BuildConfig
import com.br.composetest.R
import com.br.composetest.domain.destinations.Home
import com.br.composetest.ui.home.HomeScreenParam
import org.koin.androidx.compose.koinViewModel

@Composable
fun LoginScreen(navHostController: NavHostController) {
    val viewModel = koinViewModel<LoginScreenViewModel>()
    val state by viewModel.state.collectAsState()
    navigationTo(viewModel, navHostController, state)
    LoginForm { email, password ->
        viewModel.handleAction(LoginScreenAction.Login(email, password))
    }
}

@Composable
private fun LoginForm(onClickLogin: (String, String) -> Unit) {
    val email = rememberSaveable { mutableStateOf(String()) }
    val password = rememberSaveable { mutableStateOf(String()) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(Spacings.sm),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.login_screen_title),
            style = MaterialTheme.typography.h1
        )
        Spacer(modifier = Modifier.height(Spacings.xxs))
        OutlineInput(email)
        Spacer(modifier = Modifier.height(Spacings.xxs))
        OutlineHiddenInput(password, ImeAction.Done)
        Spacer(modifier = Modifier.height(Spacings.lm))
        Button(
            text = stringResource(R.string.login_screen_button_text),
            modifier = Modifier.fillMaxWidth(),
        ) {
            onClickLogin.invoke(email.value, password.value)
        }
        Text(
            text = BuildConfig.APPLICATION_ID,
            style = MaterialTheme.typography.h1
        )
    }
}

private fun navigationTo(
    viewModel: LoginScreenViewModel,
    navHostController: NavHostController,
    state: LoginScreenState
) = state.navigation?.also {
    when (it) {
        LoginScreenNavigation.Home -> navHostController.navigate(
            Home.getRouteForNavigationFormatted(HomeScreenParam(loginSuccess = true))
        )
    }
    viewModel.handleAction(LoginScreenAction.ResetState)
}

//region Preview

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
            LoginForm { email, password -> }
        }
    }
}

//endregion