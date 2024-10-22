package com.movie.designsystem.component

import android.graphics.Movie
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.movie.designsystem.theme.MovieTheme

@Composable
fun MovieScaffold(
    modifier: Modifier = Modifier,
    containerColor: Color = MovieTheme.colors.background.defaultBase,
    navigationIcon: @Composable () -> Unit = {},
    title: @Composable () -> Unit = {},
    titleThickness: Dp = 0.5.dp,
    actions: @Composable RowScope.() -> Unit = {},
    bottomBar: @Composable () -> Unit = {},
    contents: @Composable (PaddingValues) -> Unit = {}
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            MovieTopAppBar(
                navigationIcon = navigationIcon,
                title = title,
                actions = actions,
                thickness = titleThickness
            )
        },
        bottomBar = bottomBar,
        containerColor = containerColor
    ) { paddingValues ->
        contents(paddingValues)
    }
}

@Composable
fun MovieScaffold(
    modifier: Modifier = Modifier,
    containerColor: Color = MovieTheme.colors.background.defaultBase,
    navigationIcon: @Composable () -> Unit = {},
    titleString: String = "",
    titleThickness: Dp = 0.5.dp,
    actions: @Composable RowScope.() -> Unit = {},
    bottomBar: @Composable () -> Unit = {},
    contents: @Composable (PaddingValues) -> Unit = {}
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            MovieTopAppBar(
                navigationIcon = navigationIcon,
                titleString = titleString,
                actions = actions,
                thickness = titleThickness
            )
        },
        bottomBar = bottomBar,
        containerColor = containerColor
    ) { paddingValues ->
        contents(paddingValues)
    }
}
