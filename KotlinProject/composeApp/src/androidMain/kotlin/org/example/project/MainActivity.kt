package org.example.project

import ui.app.App
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.flow.MutableStateFlow

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            val backClickListener by lazy {  MutableStateFlow<Boolean>(false)}

            BackHandler {
                backClickListener.value = true
            }


            App(::finish)


        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()


}