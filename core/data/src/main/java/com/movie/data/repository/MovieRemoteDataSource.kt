package com.movie.data.repository

import com.movie.domain.model.MovieDetailEntity

internal interface MovieRemoteDataSource {

    suspend fun getMovieDetailById(id: Int): MovieDetailEntity
}
