package com.moviedb

import android.app.Application
import com.moviedb.model.AppDatabase
import com.moviedb.model.dao.MovieDao
import com.moviedb.model.viewmodel.MovieViewModel
import com.moviedb.networking.MovieRepository
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel

import org.koin.core.context.startKoin
import org.koin.dsl.module

class MovieDBApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MovieDBApp)
            modules(appModule)
        }
    }


    val appModule = module {
        single<MovieRepository> { MovieRepository() }
        single { AppDatabase.invoke(androidContext()) }
        fun provideMovieDao(database: AppDatabase): MovieDao {
            return database.movieDao()
        }
        single { provideMovieDao(get()) }
        viewModel { MovieViewModel() }
    }
}