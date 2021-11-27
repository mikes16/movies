package com.gamecast.domain.usecase

import com.gamecast.domain.models.Movies
import com.gamecast.domain.repository.MoviesRepository
import com.gamecast.utils.Failure
import com.gamecast.utils.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Get a list popular movies
 * */
class GetPopularMoviesUseCase @Inject constructor(
    private val repository: MoviesRepository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) {

    suspend operator fun invoke(): Flow<Result<Failure, Movies>> = withContext(dispatcher) {
        repository.getPopularMovies()
    }

}