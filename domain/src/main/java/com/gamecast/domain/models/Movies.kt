package com.gamecast.domain.models

data class Movies(
    val page: Int = 0,
    val movies: List<Movie> = listOf(),
    val totalPages: Int = 0,
    val totalMovies: Int = 0
)