package com.example.pruebapc.data.model

import com.google.gson.annotations.SerializedName

data class MovieWrapper(
    @SerializedName("results")
    val movies: List<Movie>
)

data class Movie(
    val id: Int,
    val title: String,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("vote_average")
    val voteAverage: Double,
    var isFavorite: Boolean = false
)
