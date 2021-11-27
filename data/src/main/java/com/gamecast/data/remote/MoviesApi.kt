package com.gamecast.data.remote

import com.gamecast.data.remote.entities.MoviesEntity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface MoviesApi {

    @GET("3/movie/popular")
    suspend fun getPopularMovies(
        @Query("page") page: Int
    ): Response<MoviesEntity>

}