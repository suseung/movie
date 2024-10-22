package com.movie.designsystem.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.movie.designsystem.ThemePreview
import com.movie.designsystem.theme.MovieTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieTopAppBar(
    modifier: Modifier = Modifier,
    thickness: Dp = 0.5.dp,
    titleString: String = "",
    navigationIcon: @Composable () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {}
) {
    Column {
        TopAppBar(
            modifier = modifier,
            title = {
                Text(
                    text = titleString,
                    style = MovieTheme.typos.regular.font18,
                    color = MovieTheme.colors.label.onBgPrimary
                )
            },
            navigationIcon = navigationIcon,
            actions = actions,
            windowInsets = WindowInsets(top = 0.dp)
        )
        if (thickness != 0.dp) {
            HorizontalDivider(color = MovieTheme.colors.label.onBgSecondary, thickness = thickness)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieTopAppBar(
    modifier: Modifier = Modifier,
    thickness: Dp = 0.5.dp,
    title: @Composable () -> Unit,
    navigationIcon: @Composable () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {},
) {
    Column {
        TopAppBar(
            modifier = modifier,
            title = title,
            navigationIcon = navigationIcon,
            actions = actions,
            windowInsets = WindowInsets(top = 0.dp)
        )
        if (thickness != 0.dp) {
            HorizontalDivider(color = MovieTheme.colors.label.onBgSecondary, thickness = thickness)
        }
    }
}

@ThemePreview
@Composable
fun MovieTopAppBarPreview() {
    MovieTheme {
        MovieTopAppBar(
            title = { Text("MovieTopAppBar") }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieTopCenterAppBar(
    modifier: Modifier = Modifier,
    thickness: Dp = 0.5.dp,
    titleString: String = "",
    navigationIcon: @Composable () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {}
) {
    Column {
        CenterAlignedTopAppBar(
            modifier = modifier,
            title = {
                Text(
                    text = titleString,
                    style = MovieTheme.typos.bold.font18,
                    color = MovieTheme.colors.label.onBgPrimary
                )
            },
            navigationIcon = navigationIcon,
            actions = actions,
            windowInsets = WindowInsets(top = 0.dp)
        )
        if (thickness != 0.dp) {
            HorizontalDivider(color = MovieTheme.colors.label.onBgSecondary, thickness = thickness)
        }
    }
}

@ThemePreview
@Composable
fun MovieTopCenterAppBarPreview() {
    MovieTheme {
        MovieTopCenterAppBar(titleString = "MovieTopCenterAppBar")
    }
}
