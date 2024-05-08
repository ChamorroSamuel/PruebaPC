package com.example.pruebapc.data.local

import com.example.pruebapc.MyApplication

object MovieDaoFactory {
    fun getMovieDao(): MovieDao {
        return AppDatabase.getInstance(MyApplication.getContext()).getMovieDao()
    }
}