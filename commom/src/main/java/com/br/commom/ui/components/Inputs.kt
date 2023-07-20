package com.br.commom.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.br.commom.R
import com.br.commom.ui.theme.Purple500
import com.br.commom.ui.theme.Purple700

@Composable
fun Input(text: MutableState<String>) {
    TextField(
        value = text.value,
        onValueChange = { text.value = it },
        label = { Text(String()) },
        modifier = Modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colors.background),
        keyboardOptions = KeyboardOptions(
            capitalization = KeyboardCapitalization.None,
            autoCorrect = true,
            keyboardType = KeyboardType.Text,
        ),
        singleLine = true
    )
}

@Composable
fun OutlineInput(
    text: MutableState<String>,
    imeAction: ImeAction = ImeAction.Next
) {
    val focusManager = LocalFocusManager.current
    OutlinedTextField(
        value = text.value,
        onValueChange = { text.value = it },
        label = { Text(String()) },
        maxLines = 1,
        singleLine = true,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Purple700,
            unfocusedBorderColor = Purple500
        ),
        modifier = Modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colors.background),
        keyboardOptions = KeyboardOptions(
            capitalization = KeyboardCapitalization.None,
            autoCorrect = true,
            keyboardType = KeyboardType.Text,
            imeAction = imeAction
        ),
        keyboardActions = KeyboardActions {
            if (imeAction == ImeAction.Next) {
                focusManager.moveFocus(FocusDirection.Down)
            } else {
                focusManager.clearFocus()
            }
        }
    )
}

@Composable
fun OutlineHiddenInput(
    text: MutableState<String>,
    imeAction: ImeAction = ImeAction.Next
) {
    val focusManager = LocalFocusManager.current
    var showPassword by rememberSaveable { mutableStateOf(false) }
    OutlinedTextField(
        value = text.value,
        onValueChange = { text.value = it },
        label = { Text(String()) },
        maxLines = 1,
        singleLine = true,
        visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Purple700,
            unfocusedBorderColor = Purple500
        ),
        modifier = Modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colors.background),
        keyboardOptions = KeyboardOptions(
            capitalization = KeyboardCapitalization.None,
            autoCorrect = true,
            keyboardType = KeyboardType.Text,
            imeAction = imeAction
        ),
        keyboardActions = KeyboardActions {
            if (imeAction == ImeAction.Next) {
                focusManager.moveFocus(FocusDirection.Down)
            } else {
                focusManager.clearFocus()
            }
        },
        trailingIcon = {
            val (icon, iconColor) = if (showPassword) {
                Pair(Icons.Filled.Visibility, Purple500)
            } else {
                Pair(Icons.Filled.VisibilityOff, Purple500)
            }
            IconButton(onClick = { showPassword = showPassword.not() }) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = iconColor
                )
            }
        }
    )
}