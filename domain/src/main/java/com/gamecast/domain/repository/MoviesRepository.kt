package com.gamecast.domain.repository

import com.gamecast.domain.models.Movie

interface MoviesRepository {

    fun getPopularMovies(): List<Movie>

}