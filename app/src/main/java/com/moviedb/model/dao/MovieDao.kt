package com.moviedb.model.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.moviedb.model.data.Movie

@Dao
interface MovieDao {
    @Insert(onConflict = REPLACE)
    suspend fun save(movie:Movie)

    @Query("SELECT * FROM movie")
    suspend fun getMovies():List<Movie>?
}