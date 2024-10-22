package com.movie.data.model

import com.movie.domain.model.MovieDetailEntity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class MovieDetailResponse(
    @SerialName("original_title") val title: String,
    @SerialName("overview") val overview: String,
    @SerialName("poster_path") val posterPath: String
): DataModel

internal fun MovieDetailResponse.toDomain(): MovieDetailEntity {
    return MovieDetailEntity(
        title = title,
        overview = overview,
        posterPath = posterPath
    )
}
