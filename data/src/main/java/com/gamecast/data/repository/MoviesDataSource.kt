package com.gamecast.data.repository

import com.gamecast.domain.models.Movies
import com.gamecast.utils.Failure
import com.gamecast.utils.Result

interface MoviesDataSource {

    suspend fun getPopularMovies(): Result<Failure, Movies>

}