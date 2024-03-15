package ui.app

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.ui.tooling.preview.Preview
import ui.navigation.RootComponent
import ui.screens.auth.ForgotScreen
import ui.screens.auth.LogInScreen

@OptIn(ExperimentalResourceApi::class)
@Composable
@Preview
fun App(root: RootComponent, finish: (() -> Unit)? = null) {

    MaterialTheme {

        val childStack by root.childStack.subscribeAsState()
        Children(
            stack = childStack,
            animation = stackAnimation(slide())
        ) { child ->
            when(val instance = child.instance) {
                is RootComponent.Child.ChildLogInScreen -> LogInScreen(instance.component)
                is RootComponent.Child.ChildForgotPasswordScreen -> ForgotScreen(instance.component)
            }
        }

    }
}
