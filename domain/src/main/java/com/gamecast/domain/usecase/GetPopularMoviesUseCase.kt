package com.gamecast.domain.usecase

import com.gamecast.domain.models.Movie
import com.gamecast.domain.repository.MoviesRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

/**
 * Get a list popular movies
 * */
class GetPopularMoviesUseCase @Inject constructor(
    val repository: MoviesRepository,
    val dispatcher: CoroutineDispatcher = Dispatchers.IO
) {

    operator fun invoke(): List<Movie> {
        return repository.getPopularMovies()
    }

}