package com.moviedb.networking.interfaces

import com.moviedb.BuildConfig
import com.moviedb.networking.reponses.MovieListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesHandler {

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("page") page:Int = 1,@Query("api_key") key:String =
            BuildConfig.API_KEY) :
            Response<MovieListResponse>
}