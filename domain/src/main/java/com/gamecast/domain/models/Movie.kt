package com.gamecast.domain.models

data class Movie(
    val id: String,
    val backdropImg: String,
    val poster: String,
    val title: String,
    val overview: String,
    val popularity: Float
)