package ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import kotlinproject.composeapp.generated.resources.Res
import kotlinproject.composeapp.generated.resources.ic_logo
import kotlinproject.composeapp.generated.resources.img_bg_phone
import kotlinx.coroutines.flow.MutableStateFlow
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import ui.composables.BaseTextField
import ui.composables.BaseTextLabel


@OptIn(ExperimentalResourceApi::class)
@Composable
fun LogInScreen(finish: (() -> Unit)? = null) {

    val email by lazy { MutableStateFlow("") }

    Box {

        Image(
            painterResource(Res.drawable.img_bg_phone),
            null,
            modifier = Modifier.fillMaxWidth().clickable {
                finish?.invoke()
            },
            contentScale = ContentScale.Crop
        )

        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            Image(
                painterResource(Res.drawable.ic_logo),
                null,
                modifier = Modifier.fillMaxWidth().wrapContentHeight().padding(0.dp, 100.dp),
                contentScale = ContentScale.Inside
            )

            BaseTextLabel(text = "Email Address", scope = this)
            BaseTextField(hint = "Enter email", email)


        }

    }


}