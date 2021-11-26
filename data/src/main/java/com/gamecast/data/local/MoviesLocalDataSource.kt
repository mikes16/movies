package com.gamecast.data.local

import com.gamecast.data.remote.entities.MovieEntity
import com.gamecast.data.repository.MoviesDataSource

class MoviesLocalDataSource: MoviesDataSource {

    override fun getPopularMovies(): List<MovieEntity> {
        return listOf()
    }
}