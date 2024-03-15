package ui.screens.auth

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value

class LogInScreenComponent(
    componentContext: ComponentContext,
     val onBackClick:()->Unit,
     val onNavigateToScreenForgot: () -> Unit
): ComponentContext by componentContext {

    var email = MutableValue("")
        private set
    var password = MutableValue("")
        private set



}