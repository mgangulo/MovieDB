package com.moviedb.model.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.moviedb.model.data.Movie
import com.moviedb.networking.MovieRepository
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent
import org.koin.core.inject

class MovieViewModel : ViewModel(),KoinComponent {

    val movies: MutableLiveData<List<Movie>> = MutableLiveData()
    val movieRepository:MovieRepository by inject()

    fun getPopularMovies() = viewModelScope.launch {
        kotlin.runCatching {
            movieRepository.getPopularMovies()
        }.run {
            onSuccess {
                Log.v("MovieResult",it.body().toString())
                movies.postValue(it.body()?.results)
            }
            onFailure {
                Log.v("MovieResult",it.toString())
                movies.postValue(movieRepository.getPopularMoviesLocal())
            }
        }
    }
}