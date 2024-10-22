package com.movie.data.repository.remote

import com.movie.data.model.toDomain
import com.movie.data.repository.MovieRemoteDataSource
import com.movie.data.service.MovieApi
import com.movie.domain.model.MovieDetailEntity
import javax.inject.Inject

internal class MovieRemoteDataSourceImpl @Inject constructor(
    private val movieApi: MovieApi
): MovieRemoteDataSource {

    override suspend fun getMovieDetailById(id: Int): MovieDetailEntity {
        return movieApi.getMovieDetail(id).toDomain()
    }
}
