package com.moviedb.networking

import com.moviedb.BuildConfig
import com.moviedb.model.dao.MovieDao
import com.moviedb.model.data.Movie
import com.moviedb.networking.interfaces.MoviesHandler
import com.moviedb.networking.reponses.MovieListResponse
import org.koin.core.KoinComponent
import org.koin.core.inject
import retrofit2.Response

class MovieRepository : KoinComponent {
    val movieDao:MovieDao by inject()
    suspend fun getPopularMovies(page:Int=1): Response<MovieListResponse> {
        val moviesHandler: MoviesHandler = RetrofitProvider.retrofit.create(MoviesHandler::class.java)
        val response:Response<MovieListResponse> = moviesHandler.getPopularMovies()
        if (response.isSuccessful && !response.body()?.results.isNullOrEmpty()){
            response.body()?.results?.forEach {
                movieDao.save(it)
            }
        }
        return response;
    }
    suspend fun getPopularMoviesLocal(): List<Movie>? {
        return movieDao.getMovies();
    }
}