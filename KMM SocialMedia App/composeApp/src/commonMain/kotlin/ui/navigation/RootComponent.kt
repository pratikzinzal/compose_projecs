package ui.navigation


import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.popTo
import com.arkivanov.decompose.router.stack.pushNew
import com.arkivanov.essenty.backhandler.BackCallback
import kotlinx.serialization.Serializable
import ui.screens.auth.ForgotPasswordScreenComponent
import ui.screens.auth.LogInScreenComponent


class RootComponent(
    componentContext: ComponentContext
) : ComponentContext by componentContext {

    private val navigation = StackNavigation<Configuration>()
    val childStack = childStack(
        source = navigation,
        serializer = Configuration.serializer(),
        initialConfiguration = Configuration.ConfigLogInScreen,
        handleBackButton = true,
        childFactory = ::createChild,
    )

    @OptIn(ExperimentalDecomposeApi::class)
    private fun createChild(
        config: Configuration,
        context: ComponentContext
    ): Child {
        return when (config) {
            Configuration.ConfigLogInScreen -> Child.ChildLogInScreen(
                LogInScreenComponent(
                    componentContext = context,
                    onBackClick = {

                    },
                    onNavigateToScreenForgot = {
                        navigation.pushNew(Configuration.ConfigForgotPasswordScreen)
                    }
                )
            )

            Configuration.ConfigForgotPasswordScreen -> Child.ChildForgotPasswordScreen(
                ForgotPasswordScreenComponent(
                    componentContext = context,
                    onBackClick = {
                        navigation.pop()
                    }
                )
            )
        }
    }

    fun onBackClicked(toIndex: Int) {

        navigation.popTo(index = toIndex)
    }

    sealed class Child {
        data class ChildLogInScreen(val component: LogInScreenComponent) : Child()
        data class ChildForgotPasswordScreen(val component: ForgotPasswordScreenComponent) : Child()
    }

    @Serializable
    sealed class Configuration {
        @Serializable
        data object ConfigLogInScreen : Configuration()

        @Serializable
        data object ConfigForgotPasswordScreen : Configuration()
    }
}