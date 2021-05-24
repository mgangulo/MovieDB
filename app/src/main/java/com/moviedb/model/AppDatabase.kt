package com.moviedb.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.moviedb.model.dao.MovieDao
import com.moviedb.model.data.Movie

@Database(entities = [Movie::class], version = 1)
abstract class AppDatabase : RoomDatabase(){
    abstract fun movieDao():MovieDao

    companion object {

        @Volatile
        private var instance : AppDatabase? = null

        private val LOCK = Any()


        operator fun invoke(context: Context) = instance
            ?: synchronized(LOCK) {
                instance
                    ?: buildDatabase(
                        context
                    ).also {
                        instance = it
                    }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java, "appmovie.db"
            ).fallbackToDestructiveMigration().build()

    }

}