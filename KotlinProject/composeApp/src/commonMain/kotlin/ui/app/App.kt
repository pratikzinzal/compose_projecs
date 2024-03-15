package ui.app

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.ui.tooling.preview.Preview
import ui.screens.auth.ForgotScreen

import ui.screens.auth.LogInScreen

@OptIn(ExperimentalResourceApi::class)
@Composable
@Preview
fun App(finish: (() -> Unit)? = null) {

    MaterialTheme {

//        SplashScreen()

//        LogInScreen(finish)
        ForgotScreen()

    }
}
