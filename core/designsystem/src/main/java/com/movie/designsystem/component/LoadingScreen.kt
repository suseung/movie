package com.movie.designsystem.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.movie.designsystem.ThemePreview
import com.movie.designsystem.theme.MovieTheme

@Composable
fun LoadingScreen(
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier.fillMaxSize()) {
        CircularProgressIndicator(
            modifier = Modifier.size(60.dp)
                .align(Alignment.Center),
            color = MovieTheme.colors.system.yellow,
            progress = { 0.5f }
        )
    }
}

@ThemePreview
@Composable
fun LoadingScreenPreview() {
    LoadingScreen()
}
