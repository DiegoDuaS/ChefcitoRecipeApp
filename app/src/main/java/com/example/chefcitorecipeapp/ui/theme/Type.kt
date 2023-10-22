package com.example.chefcitorecipeapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.chefcitorecipeapp.R


val customFontFamily = FontFamily(
    Font(R.font.montserratextralight),
    Font(R.font.montserratextralightitalic),
    Font(R.font.montserratitalic),
    Font(R.font.montserratlight),
    Font(R.font.montserratlightitalic),
    Font(R.font.montserratmedium),
    Font(R.font.montserratmediumitalic),
    Font(R.font.montserratregular),
    Font(R.font.montserratthin),
    Font(R.font.montserratthinitalic),
    Font(R.font.montserratextralight)
)

val lightFamily = FontFamily(
    Font(R.font.montserratlight),
)

val mediumFamily = FontFamily(
    Font(R.font.montserratmedium),
)

// Set of Material typography styles to start with
val Typography = Typography(
    bodySmall = TextStyle(
        fontFamily = lightFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 15.sp,
        lineHeight = 5.sp,
        letterSpacing = 0.5.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = customFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp,
        lineHeight = 5.sp,
        letterSpacing = 0.5.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = lightFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 30.sp,
        lineHeight = 5.sp,
        letterSpacing = 0.5.sp
    ),
    titleLarge = TextStyle(
        fontFamily = lightFamily,
        fontWeight = FontWeight.ExtraLight,
        fontSize = 60.sp,
        lineHeight = 80.sp,
        letterSpacing = 0.sp
    ),
    titleMedium =  TextStyle(
        fontFamily = mediumFamily,
        fontWeight = FontWeight.Thin,
        fontSize = 30.sp,
        lineHeight = 34.sp,
        letterSpacing = 0.sp
    ),
    titleSmall = TextStyle(
        fontFamily = mediumFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp,
        lineHeight = 30.sp,
        letterSpacing = 0.sp
    ),
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)