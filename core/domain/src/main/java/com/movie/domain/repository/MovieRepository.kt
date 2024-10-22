package com.movie.domain.repository

import com.movie.domain.model.MovieDetailEntity

interface MovieRepository {
    suspend fun getMovieDetailById(id: Int): MovieDetailEntity
}
