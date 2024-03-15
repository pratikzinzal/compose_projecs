package ui.screens.auth

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import kotlinx.coroutines.flow.MutableStateFlow
import ui.composables.AuthHeader
import ui.composables.BaseAuthBottomText
import ui.composables.BaseButton
import ui.composables.BaseTextField
import ui.composables.BaseTextLabel

@Composable
fun ForgotScreen(component: ForgotPasswordScreenComponent) {


    val scrollState = rememberScrollState()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxHeight().verticalScroll(scrollState)
    ) {

        AuthHeader("Forgot Password", "Let’s help recover your account") {
            component.onBackClick()
        }


        BaseTextLabel(text = "Email Address", scope = this)
        BaseTextField(
            hint = "Enter Email", component.email, KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            )
        )

        BaseTextLabel(text = "Phone Number", scope = this)
        BaseTextField(
            hint = "Enter PhoneNumber", component.number, KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ), maxLength = 10
        )


        Spacer(Modifier.weight(1f))
        BaseButton("Next") {

        }
        BaseAuthBottomText("Do not have an Account?", " Sign up", endClick = {

        })



    }


}