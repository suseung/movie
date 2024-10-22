package com.movie.data.service

import com.movie.data.BuildConfig
import com.movie.data.model.MovieDetailResponse
import com.movie.data.util.Version.V3
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

internal interface MovieApi {

    @GET("$V3/movie/{movie_id}")
    suspend fun getMovieDetail(
        @Path("movie_id") id: Int,
        @Query("api_key") key: String = BuildConfig.apiKey
    ): MovieDetailResponse
}
