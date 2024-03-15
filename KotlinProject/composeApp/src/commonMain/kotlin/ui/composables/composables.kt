package ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinproject.composeapp.generated.resources.Res
import kotlinproject.composeapp.generated.resources.ic_button
import kotlinx.coroutines.flow.MutableStateFlow
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import ui.theme.colorPrimary
import ui.theme.colorTextFieldBackGround
import ui.theme.color_000000_70f
import ui.theme.getFontType


@OptIn(ExperimentalResourceApi::class)
@Composable
fun BaseButton(buttonText: String, onClick: () -> Unit) {


    Box(Modifier.fillMaxWidth().wrapContentHeight()) {

        Image(
            painterResource(Res.drawable.ic_button),
            null,
            Modifier.wrapContentWidth().wrapContentHeight().align(Alignment.Center)
                .clickable { onClick() })

        Text(
            color = Color.White,
            text = buttonText,
            modifier = Modifier.align(Alignment.Center),
            style = getFontType().textButton
        )

    }


}

@Composable
fun BaseTextField(hint: String, textValue: MutableStateFlow<String>) {

    val textFiled by textValue.collectAsState()
    var hasFocus by remember { mutableStateOf(false) }


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
            Text(text = hint)
        },
        shape = RoundedCornerShape(10.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            backgroundColor = colorTextFieldBackGround,
            focusedBorderColor = Color.Unspecified,
            unfocusedBorderColor = Color.Unspecified,
            cursorColor = colorPrimary,
        ),
        singleLine = true,
        maxLines = 1,

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


