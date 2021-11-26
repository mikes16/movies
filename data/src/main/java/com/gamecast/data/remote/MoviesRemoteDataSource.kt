package com.gamecast.data.remote

import com.gamecast.data.remote.entities.MovieEntity
import com.gamecast.data.repository.MoviesDataSource

class MoviesRemoteDataSource: MoviesDataSource {
    override fun getPopularMovies(): List<MovieEntity> {
        return listOf()
    }
}