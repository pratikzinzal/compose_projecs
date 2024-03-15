package ui.theme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Green


val colorPallete =
    darkColors(
        primary = Green,
        primaryVariant = Green,
        secondary = Green,
        secondaryVariant = Green,
        background = Black,
        surface = Black,
        onPrimary = Color.White,
        onSecondary = Black,
        onBackground = Black,
        onSurface = Black,
        error = Black,
        onError = Color.Red
    )

