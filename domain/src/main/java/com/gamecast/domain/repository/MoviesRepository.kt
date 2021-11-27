package com.gamecast.domain.repository

import com.gamecast.domain.models.Movie
import com.gamecast.domain.models.Movies
import com.gamecast.utils.Failure
import com.gamecast.utils.Result
import kotlinx.coroutines.flow.Flow

interface MoviesRepository {

    suspend fun getPopularMovies(): Flow<Result<Failure,Movies>>

}