package com.gamecast.data.remote.entities

import com.gamecast.domain.models.Movies
import com.google.gson.annotations.SerializedName

data class MoviesEntity(
    @SerializedName("page")
    val page: Int = 0,
    @SerializedName("total_pages")
    val totalPages: Int = 0,
    @SerializedName("results")
    val results: List<MovieEntity> = listOf()
)

fun MoviesEntity.toMovies(): Movies = Movies(
    page = page,
    totalPages = totalPages,
    totalMovies = 0,
    movies = results.map { it.toMovie() }
)