package ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import kotlinproject.composeapp.generated.resources.Res
import kotlinproject.composeapp.generated.resources.pop_bold
import kotlinproject.composeapp.generated.resources.pop_extra_bold
import kotlinproject.composeapp.generated.resources.pop_light
import kotlinproject.composeapp.generated.resources.pop_medium
import kotlinproject.composeapp.generated.resources.pop_regular
import kotlinproject.composeapp.generated.resources.pop_semi_bold
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.Font



data class FontType(
    val textButton: TextStyle,
    val textLabel: TextStyle
)

@OptIn(ExperimentalResourceApi::class)
@Composable
fun getFontType(): FontType {

    val popLight = FontFamily(
        Font(Res.font.pop_light, FontWeight.Normal, FontStyle.Normal)
    )

    val popRegular = FontFamily(
        Font(Res.font.pop_regular, FontWeight.Normal, FontStyle.Normal)
    )

    val popMedium = FontFamily(
        Font(Res.font.pop_medium, FontWeight.Normal, FontStyle.Normal)
    )

    val popSemiBold = FontFamily(
        Font(Res.font.pop_semi_bold, FontWeight.Normal, FontStyle.Normal)
    )
    val popBold = FontFamily(

        Font(Res.font.pop_bold, FontWeight.Normal, FontStyle.Normal)
    )
    val popExtraBold = FontFamily(
        Font(Res.font.pop_extra_bold, FontWeight.Normal, FontStyle.Normal)
    )

    return FontType(
        textButton = TextStyle(
            fontFamily = popSemiBold,
            fontWeight = FontWeight.Normal,
            fontSize = 18.sp,
        ),
        textLabel = TextStyle(
            fontFamily = popMedium,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
        )
    )

}