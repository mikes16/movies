package com.gamecast.data.remote

import com.gamecast.data.remote.entities.MoviesEntity
import com.gamecast.data.remote.entities.toMovies
import com.gamecast.data.repository.MoviesDataSource
import com.gamecast.domain.models.Movies
import com.gamecast.utils.Failure
import com.gamecast.utils.Result
import com.gamecast.utils.map
import javax.inject.Inject

class MoviesRemoteDataSource @Inject constructor(
    private val moviesApi: MoviesApi
) : MoviesDataSource {

    override suspend fun getPopularMovies(): Result<Failure, Movies> {
        return moviesApi.getPopularMovies(1).request(MoviesEntity()).map { it.toMovies() }
    }
}