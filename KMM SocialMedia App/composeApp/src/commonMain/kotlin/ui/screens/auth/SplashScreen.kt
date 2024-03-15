package ui.screens.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import kmmsocialmediaapp.composeapp.generated.resources.Res
import kmmsocialmediaapp.composeapp.generated.resources.ic_logo
import kmmsocialmediaapp.composeapp.generated.resources.img_bg_phone
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun SplashScreen() {

    Box {
        Image(
            painterResource(Res.drawable.img_bg_phone),
            null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Image(
            painterResource(Res.drawable.ic_logo), null, modifier = Modifier.fillMaxSize().align(
                Alignment.Center
            ),
            contentScale = ContentScale.Inside
        )
    }


}