package com.movie.home.model

import com.movie.domain.model.MovieDetailEntity

data class MovieDetailUiModel(
    val title: String = "",
    val overview: String = "",
    val posterPath: String = ""
) {
    val fullPosterPath = "https://image.tmdb.org/t/p/original/$posterPath"
}

fun MovieDetailEntity.toUiModel(): MovieDetailUiModel {
    return MovieDetailUiModel(
        title = title,
        overview = overview,
        posterPath = posterPath
    )
}
