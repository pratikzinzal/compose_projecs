package ui.composables

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import com.arkivanov.decompose.value.MutableValue
import kmmsocialmediaapp.composeapp.generated.resources.Res
import kmmsocialmediaapp.composeapp.generated.resources.ic_eye_close
import kmmsocialmediaapp.composeapp.generated.resources.ic_back_arrow
import kmmsocialmediaapp.composeapp.generated.resources.ic_eye_open
import kotlinx.coroutines.flow.MutableStateFlow
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import ui.theme.colorPrimary
import ui.theme.colorTextFieldBackGround
import ui.theme.color_000000_70f
import ui.theme.getFontType


@OptIn(ExperimentalResourceApi::class)
@Composable
fun BaseButton(buttonText: String, onButtonClick: () -> Unit) {

    Button(
        onClick = { onButtonClick() },
        modifier = Modifier.fillMaxWidth().wrapContentHeight()
            .padding(horizontal = 25.dp, vertical = 10.dp),
        content = {
            Text(
                text = buttonText,
                color = Color.White,
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 10.dp),
                style = getFontType().textButton
            )
        },
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = colorPrimary),
        elevation = ButtonDefaults.elevation(
            defaultElevation = 0.dp,
            pressedElevation = 0.dp,
            hoveredElevation = 0.dp,
            disabledElevation = 0.dp,
            focusedElevation = 0.dp
        )
    )

}


@Composable
fun BaseTextField(
    hint: String,
    textValue: MutableValue<String>,
    keyboardOptions: KeyboardOptions = KeyboardOptions(
        imeAction = ImeAction.Next

    ),
    maxLength:Int= Int.MAX_VALUE
) {

    val textFiled by textValue.subscribeAsState()
    var hasFocus by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = textFiled,
        onValueChange = {

            if (it.length <= maxLength) textValue.value  = it
        },
        modifier = Modifier.fillMaxWidth().padding(horizontal = 25.dp, vertical = 0.dp).border(
            width = 1.dp,
            color = if (hasFocus) colorPrimary else Color.Transparent,
            shape = RoundedCornerShape(10.dp)
        ).onFocusChanged { focusState -> hasFocus = focusState.hasFocus },
        placeholder = {
            Text(
                text = hint,
                style = getFontType().textField
            )
        },
        shape = RoundedCornerShape(10.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            backgroundColor = colorTextFieldBackGround,
            focusedBorderColor = Color.Unspecified,
            unfocusedBorderColor = Color.Unspecified,
            cursorColor = colorPrimary,
        ),
        singleLine = true,
        textStyle = getFontType().textField,
        maxLines = 1, keyboardOptions = keyboardOptions,


        )
}


@OptIn(ExperimentalResourceApi::class)
@Composable
fun BaseTextFieldPassword(
    hint: String,
    textValue: MutableValue<String>,
    keyboardOptions: KeyboardOptions = KeyboardOptions(
        imeAction = ImeAction.Next
    )
) {

    val textFiled by textValue.subscribeAsState()
    var hasFocus by remember { mutableStateOf(false) }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }



    OutlinedTextField(
        value = textFiled,
        onValueChange = {
            textValue.value = it
        },
        modifier = Modifier.fillMaxWidth().padding(horizontal = 25.dp, vertical = 0.dp).border(
            width = 1.dp,
            color = if (hasFocus) colorPrimary else Color.Transparent,
            shape = RoundedCornerShape(10.dp)
        ).onFocusChanged { focusState -> hasFocus = focusState.hasFocus },

        placeholder = {
            Text(
                text = hint,
                style = getFontType().textField
            )
        },
        shape = RoundedCornerShape(10.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            backgroundColor = colorTextFieldBackGround,
            focusedBorderColor = Color.Unspecified,
            unfocusedBorderColor = Color.Unspecified,
            cursorColor = colorPrimary,
        ),
        singleLine = true,
        maxLines = 1, keyboardOptions = keyboardOptions,
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        textStyle = getFontType().textField,
        trailingIcon = {
            val image = if (passwordVisible)
                painterResource(Res.drawable.ic_eye_close)
            else
                painterResource(Res.drawable.ic_eye_open)

            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                Icon(image, contentDescription = "Visibility Toggle")
            }
        }
    )
}


@Composable
fun BaseTextLabel(modifier: Modifier = Modifier, text: String, scope: ColumnScope) {

    scope.apply {
        Text(
            text = text,
            modifier = modifier.fillMaxWidth().padding(25.dp, 10.dp).align(Alignment.Start),
            style = getFontType().textLabel,
            color = color_000000_70f
        )

    }


}

@Composable
fun BaseAuthBottomText(
    startText: String,
    endText: String,
    startClick: (() -> Unit)? = null,
    endClick: (() -> Unit)? = null,

    ) {

    Row(
        modifier = Modifier.fillMaxWidth().padding(0.dp, 37.dp, 0.dp, 50.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = startText,
            modifier = Modifier.wrapContentSize().apply {
                startClick?.let {
                    clickable {
                        it()
                    }
                }
            },
            style = getFontType().textMedium14sp,
            color = Color.Black,
        )
        Text(
            text = endText,
            modifier = Modifier.wrapContentSize().apply {
                endClick?.let {
                    clickable {
                        it()
                    }
                }
            },
            style = getFontType().textMedium14sp,
            color = colorPrimary,
        )


    }

}


@OptIn(ExperimentalResourceApi::class)
@Composable
fun AuthHeader(
    titleText: String = "",
    subTitleTExt: String = "",
    onBackClick: (() -> Unit)
) {
    Column(Modifier.fillMaxWidth().wrapContentHeight()) {

        Spacer(Modifier.height(10.dp))
        IconButton(onClick = {
            onBackClick()
        }, modifier = Modifier.wrapContentSize().padding(5.dp, 10.dp)) {
            Icon(painterResource(Res.drawable.ic_back_arrow), contentDescription = null)
        }
        Spacer(Modifier.height(10.dp))
        Text(
            text = titleText,
            modifier = Modifier.wrapContentSize().padding(25.dp, 5.dp),
            style = getFontType().textSemiBold20sp,
            color = Color.Black,
        )
        Text(
            text = subTitleTExt,
            modifier = Modifier.wrapContentSize().padding(25.dp, 5.dp),
            style = getFontType().textMedium16sp,
            color = color_000000_70f
        )
        Spacer(Modifier.height(10.dp))


    }

}