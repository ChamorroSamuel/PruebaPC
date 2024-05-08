package com.example.pruebapc.data.repositories

import android.util.Log
import com.example.pruebapc.data.local.MovieDao
import com.example.pruebapc.data.local.MovieDaoFactory
import com.example.pruebapc.data.local.MovieEntity
import com.example.pruebapc.data.model.Movie
import com.example.pruebapc.data.model.MovieWrapper
import com.example.pruebapc.data.remote.MovieService
import com.example.pruebapc.data.remote.MovieServiceFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieRepository( private val movieService: MovieService =
    MovieServiceFactory.getMovieService(),
    private val movieDao: MovieDao =MovieDaoFactory.getMovieDao()){

    fun insert(movie:Movie){
        val movieEntity = MovieEntity(movie.id)
        movieDao.insert(movieEntity)
    }

    fun delete(movie:Movie){
        val movieEntity = MovieEntity(movie.id)
        movieDao.delete(movieEntity)
    }

    fun isFavorite(id:Int): Boolean{
        return movieDao.fetchById(id) != null
    }

    fun getMovies(path: String, Callback: (List<Movie>)-> Unit){
        val getMovies = movieService.getMovies(path)

        getMovies.enqueue(object: Callback<MovieWrapper> {
            override fun onResponse(call: Call<MovieWrapper>, response: Response<MovieWrapper>) {
                if(response.isSuccessful){
                    val movies = response.body()?.movies?: emptyList()
                    for(movie in movies){
                        movie.isFavorite = isFavorite(movie.id)
                    }
                    Callback(movies)
                }
            }

            override fun onFailure(call: Call<MovieWrapper>, t: Throwable) {
                t.message?.let{
                    Log.d("MovieRepository", it)
                }
            }
        })
    }
}