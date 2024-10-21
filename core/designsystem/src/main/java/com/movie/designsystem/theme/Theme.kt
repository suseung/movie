package com.movie.designsystem.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Density

val LightColorScheme = lightColorScheme(
    primaryContainer = Color.White,
    onPrimaryContainer = Grey90,
    secondaryContainer = Color.White,
    onSecondaryContainer = Grey90,
    surface = Color.White,
    onSurface = Grey90
)

val DarkColorScheme = darkColorScheme(
    primaryContainer = Grey90,
    onPrimaryContainer = Grey05,
    secondaryContainer = Grey80,
    onSecondaryContainer = Grey05,
    surface = Grey90,
    onSurface = Grey05
)

@Composable
fun MovieTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme
    val movieColors = if (darkTheme) DarkMovieColors else MovieColors()

    CompositionLocalProvider(
        LocalDensity provides Density(density = LocalDensity.current.density, fontScale = 1f),
        LocalMovieColors provides movieColors
    ) {
        MaterialTheme(
            colorScheme = colorScheme
        ) {
            content()
        }
    }
}

object MovieTheme {
    val colors: MovieColors
        @Composable
        get() = LocalMovieColors.current

    val typos: MovieTypography
        @Composable
        get() = LocalMovieTypography.current
}
