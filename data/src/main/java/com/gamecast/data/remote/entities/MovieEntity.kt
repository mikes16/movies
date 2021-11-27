package com.gamecast.data.remote.entities

import com.gamecast.domain.models.Movie
import com.google.gson.annotations.SerializedName

data class MovieEntity(
    @SerializedName("id")
    val id: String,
    @SerializedName("backdrop_path")
    val backdropImg: String,
    @SerializedName("poster_path")
    val poster: String,
    @SerializedName("original_title")
    val title: String,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("popularity")
    val popularity: Float
)

fun MovieEntity.toMovie(): Movie = Movie(
    id = this.id,
    backdropImg = this.backdropImg,
    poster = this.poster,
    title = this.title,
    overview = this.overview,
    popularity = this.popularity
)
