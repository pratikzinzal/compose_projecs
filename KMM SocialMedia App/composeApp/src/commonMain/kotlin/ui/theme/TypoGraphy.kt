package ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import kmmsocialmediaapp.composeapp.generated.resources.Res
import kmmsocialmediaapp.composeapp.generated.resources.pop_bold
import kmmsocialmediaapp.composeapp.generated.resources.pop_extra_bold
import kmmsocialmediaapp.composeapp.generated.resources.pop_light
import kmmsocialmediaapp.composeapp.generated.resources.pop_medium
import kmmsocialmediaapp.composeapp.generated.resources.pop_regular
import kmmsocialmediaapp.composeapp.generated.resources.pop_semi_bold
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.Font


data class FontType(
    val textButton: TextStyle,
    val textField: TextStyle,
    val textLabel: TextStyle,
    val textMedium14sp: TextStyle,
    val textMedium16sp: TextStyle,
    val textSemiBold20sp: TextStyle
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
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp,
        ),
        textField = TextStyle(
            fontFamily = popRegular,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
        ),
        textLabel = TextStyle(
            fontFamily = popMedium,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
        ),
        textMedium14sp = TextStyle(
            fontFamily = popMedium,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
        ),
        textMedium16sp = TextStyle(
            fontFamily = popMedium,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
        ),
        textSemiBold20sp = TextStyle(
            fontFamily = popSemiBold,
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp,
        ),

        )

}