package com.gamecast.data.entities

data class MoviesEntity(
    val page: Int = 0,
    val results: List<MovieEntity>
)