package com.movie.data.repository

import com.movie.domain.model.MovieDetailEntity
import com.movie.domain.repository.MovieRepository
import javax.inject.Inject

internal class MovieRepositoryImpl @Inject constructor(
    private val remoteDataSource: MovieRemoteDataSource
): MovieRepository {

    override suspend fun getMovieDetailById(id: Int): MovieDetailEntity {
        return remoteDataSource.getMovieDetailById(id)
    }
}
