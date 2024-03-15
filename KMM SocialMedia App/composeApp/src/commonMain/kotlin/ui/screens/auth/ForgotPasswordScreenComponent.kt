package ui.screens.auth

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value

class ForgotPasswordScreenComponent(
    componentContext: ComponentContext,
    private val onNavigateToScreenForgot: () -> Unit
): ComponentContext by componentContext {

    private var _text = MutableValue("")
    val text: Value<String> = _text

}