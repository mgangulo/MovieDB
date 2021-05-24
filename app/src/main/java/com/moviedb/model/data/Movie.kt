package com.moviedb.model.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Movie(
    @SerializedName("poster_path") val posterPath: String?,
    val adult: Boolean?,
    val overview: String?,
    @SerializedName("release_date") val releaseDate: String?,
    @PrimaryKey val id: Int?,
    @SerializedName("original_title") val originalTitle: String?,
    @SerializedName("original_language") val originalLanguage: String?,
    val title: String?,
    @SerializedName("backdrop_path") val backdrop: String,
    val popularity: Double?,
    @SerializedName("vote_count") val voteCount: String,
    val video: Boolean?,
    @SerializedName("vote_average") val voteAvg: Double
)
