package com.movie.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.movie.base.CollectContent
import com.movie.designsystem.ThemePreview
import com.movie.designsystem.component.LoadingScreen
import com.movie.designsystem.component.MovieScaffold
import com.movie.designsystem.component.NetworkErrorScreen
import com.movie.designsystem.theme.MovieTheme
import com.movie.home.model.MovieDetailUiModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {
    val uiState by viewModel.state.collectAsStateWithLifecycle()

    CollectContent(viewModel = viewModel) {}

    MovieScaffold(
        titleString = "home"
    ) { paddingValues ->
        when (val state = uiState) {
            is HomeState.Loading -> LoadingScreen()
            is HomeState.Success -> {
                HomeLoaded(
                    modifier = Modifier.padding(paddingValues),
                    movieDetailInfo = state.movieDetailInfo
                )
            }
            is HomeState.Error -> NetworkErrorScreen()
        }
    }

}

@Composable
fun HomeLoaded(
    modifier: Modifier = Modifier,
    movieDetailInfo: MovieDetailUiModel
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = movieDetailInfo.title,
            style = MovieTheme.typos.bold.font36,
            color = MovieTheme.colors.system.yellow,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Text(
            text = movieDetailInfo.overview,
            style = MovieTheme.typos.regular.font16,
            color = MovieTheme.colors.system.yellow,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        AsyncImage(
            model = movieDetailInfo.fullPosterPath,
            contentDescription = "movie poster",
            modifier = Modifier.size(100.dp),
            contentScale = ContentScale.Crop
        )
    }
}

@ThemePreview
@Composable
fun HomeLoadedPreview() {
    MovieTheme {
        HomeLoaded(
            movieDetailInfo = MovieDetailUiModel(
                title = "title",
                overview = "overview",
                posterPath = ""
            )
        )
    }
}
