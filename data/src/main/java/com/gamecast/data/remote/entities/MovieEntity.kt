package com.gamecast.data.remote.entities

import com.google.gson.annotations.SerializedName

data class MovieEntity(
    @SerializedName("id")
    val id: String,
    @SerializedName("backdrop_path")
    val backdropImg: String,
    @SerializedName("poster_path")
    val poster: String,
    @SerializedName("original_name", alternate = ["original_title"])
    val title: String,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("id")
    val popularity: Long,
)