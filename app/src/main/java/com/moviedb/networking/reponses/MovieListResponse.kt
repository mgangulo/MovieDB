package com.moviedb.networking.reponses

import com.google.gson.annotations.SerializedName
import com.moviedb.model.data.Movie

data class MovieListResponse(
    val page:Int,
    @SerializedName("total_results") val totalResults:Int,
    @SerializedName("total_pages") val totalPages:Int,
    val results:ArrayList<Movie>
)
