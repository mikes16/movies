package com.gamecast.data.local

import com.gamecast.data.repository.MoviesDataSource
import com.gamecast.domain.models.Movies
import com.gamecast.utils.Failure
import com.gamecast.utils.Result

class MoviesLocalDataSource : MoviesDataSource {

    override suspend fun getPopularMovies(): Result<Failure, Movies> {
        return Result.Loading
    }
}