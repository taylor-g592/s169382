package com.taylorm.s169382.presentation.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.taylorm.dissertation.R

/*
 Custom font from Google Fonts.
 https://fonts.google.com/specimen/Quicksand
 */

val quicksand = FontFamily(
    Font(R.font.quicksand_bold, FontWeight.Bold),
    Font(R.font.quicksand_light, FontWeight.Light),
    Font(R.font.quicksand_medium, FontWeight.Medium),
    Font(R.font.quicksand_regular, FontWeight.Normal),
    Font(R.font.quicksand_semi_bold, FontWeight.SemiBold)
)

/*
Typography for the app.
 */

val Typography = Typography(
    body1 = TextStyle(
        fontFamily = quicksand,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        // Apply color from color.kt file to apply in all screens
        color = TextBlack
    ),
    h1 = TextStyle(
        fontFamily = quicksand,
        fontWeight = FontWeight.Bold,
        fontSize = 30.sp,
        color = TextBlack
    ),
    h2 = TextStyle(
        fontFamily = quicksand,
        fontWeight = FontWeight.Medium,
        fontSize = 24.sp,
        color = TextBlack
    ),
    body2 = TextStyle(
        fontFamily = quicksand,
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp,
        color = TextBlack
    )
)

