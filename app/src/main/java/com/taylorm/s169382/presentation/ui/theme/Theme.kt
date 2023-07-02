package com.taylorm.s169382.presentation.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = white,
    background = backgroundWhite,
    onBackground = TextBlack,
    onPrimary = TextBlack,
    surface = backgroundWhite,
    onSurface = TextBlack,
    primaryVariant = purple
)

@Composable
fun DissertationTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    MaterialTheme(
        colors = DarkColorPalette,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}