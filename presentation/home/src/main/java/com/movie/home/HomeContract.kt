package com.movie.home

import com.movie.base.ViewEffect
import com.movie.base.ViewIntent
import com.movie.base.ViewState
import com.movie.home.model.MovieDetailUiModel

sealed interface HomeIntent : ViewIntent

sealed interface HomeState : ViewState {
    data object Loading : HomeState
    data object Error : HomeState
    data class Success(
        val movieDetailInfo: MovieDetailUiModel = MovieDetailUiModel()
    ) : HomeState
}

sealed interface HomeEffect : ViewEffect
