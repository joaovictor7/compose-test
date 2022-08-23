package com.br.composetest.ui.login

import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import com.br.commom.ui.bases.BaseActivity
import com.br.composetest.ui.main.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

private lateinit var viewModel1: LoginViewModel

@Composable
fun LoginScreen(
    navHostController: NavHostController,
    viewModel: LoginViewModel
) {
    viewModel1 = viewModel
    val login = remember { mutableStateOf("fd") }
    TextField(value = login.value, onValueChange = { login.value = it })
}