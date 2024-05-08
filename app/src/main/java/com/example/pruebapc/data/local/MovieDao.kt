package com.example.pruebapc.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MovieDao {
    @Insert
    fun insert(movieEntity: MovieEntity)

    @Delete
    fun delete(movieEntity: MovieEntity)

    @Query("SELECT * FROM movies where id = :id")
    fun fetchById(id: Int): MovieEntity?

    @Query("SELECT * FROM movies ")
    fun fetchAll(): List<MovieEntity>?
}