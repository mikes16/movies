package com.gamecast.data.repository

import com.gamecast.data.remote.entities.MovieEntity

interface MoviesDataSource {

    fun getPopularMovies(): List<MovieEntity>

}