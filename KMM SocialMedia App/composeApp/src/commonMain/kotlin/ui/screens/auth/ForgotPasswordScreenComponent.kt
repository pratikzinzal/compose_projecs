package ui.screens.auth

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value

class ForgotPasswordScreenComponent(
    componentContext: ComponentContext,
    val onBackClick:()->Unit
): ComponentContext by componentContext {

    var email = MutableValue("")
        private set
    var number = MutableValue("")
        private set

}