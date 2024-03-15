import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.ui.tooling.preview.Preview
import ui.screens.auth.ForgotScreen

import ui.screens.auth.LogInScreen

@OptIn(ExperimentalResourceApi::class)
@Composable
@Preview
fun App(finish: (() -> Unit)? = null) {

    MaterialTheme {

//        SplashScreen()



//        LogInScreen(finish)
        ForgotScreen()
//        var showContent by remember { mutableStateOf(false) }
//        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
//
//            BaseButton("Click me!") {
//                showContent = !showContent
//            }
//
//            AnimatedVisibility(showContent) {
//                val greeting = remember { Greeting().greet() }
//                Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
//                    Image(painterResource(Res.drawable.compose_multiplatform), null)
//                    Text("Compose: $greeting")
//                }
//            }
//        }
    }
}
