package com.movie.domain.model

data class MovieDetailEntity(
    val title: String,
    val overview: String,
    val posterPath: String
): DomainModel
