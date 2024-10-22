package com.movie.domain.usecase

import com.movie.domain.base.FlowUseCase
import com.movie.domain.di.IoDispatcher
import com.movie.domain.model.MovieDetailEntity
import com.movie.domain.repository.MovieRepository
import javax.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetMovieDetailsByIdUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
    @IoDispatcher ioDispatcher: CoroutineDispatcher
): FlowUseCase<Int, MovieDetailEntity>(ioDispatcher) {

    override fun execute(params: Int): Flow<MovieDetailEntity> = flow {
        emit(movieRepository.getMovieDetailById(params))
    }
}
