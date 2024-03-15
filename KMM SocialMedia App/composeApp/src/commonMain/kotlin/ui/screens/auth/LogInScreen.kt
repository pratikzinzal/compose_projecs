package ui.screens.auth

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.flow.MutableStateFlow
import org.jetbrains.compose.resources.ExperimentalResourceApi
import ui.composables.AuthHeader
import ui.composables.BaseAuthBottomText
import ui.composables.BaseButton
import ui.composables.BaseTextField
import ui.composables.BaseTextFieldPassword
import ui.composables.BaseTextLabel
import ui.theme.colorPrimary70f
import ui.theme.getFontType


@OptIn(ExperimentalResourceApi::class)
@Composable
fun LogInScreen(finish: (() -> Unit)? = null) {

    val email by lazy { MutableStateFlow("") }
    val password by lazy { MutableStateFlow("") }
    val scrollState = rememberScrollState()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxHeight().verticalScroll(scrollState)
    ) {

        AuthHeader("Log In", "Enter your credentials") {
            finish?.invoke()
        }

        BaseTextLabel(text = "Email Address", scope = this)
        BaseTextField(
            hint = "Enter Email", email, KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            )
        )


        BaseTextLabel(text = "Password", scope = this)
        BaseTextFieldPassword(
            hint = "Enter Password", password, KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            )
        )

        Text(
            text = "Forgot Password?",
            modifier = Modifier.wrapContentSize().padding(25.dp, 10.dp).align(Alignment.End)
                .clickable {

                },
            style = getFontType().textMedium14sp,
            color = colorPrimary70f,
        )
        Spacer(Modifier.weight(1f))
        BaseButton("Log In") {

        }
        BaseAuthBottomText("Do not have an Account?", " Sign up", endClick = {

        })


    }


}