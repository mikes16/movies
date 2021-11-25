package com.gamecast.domain.usecase

import com.gamecast.domain.models.Movie
import com.gamecast.domain.repository.MoviesRepository
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

/**
 * Get a list popular movies
 * */
class GetPopularMoviesUseCase @Inject constructor(
    val repository: MoviesRepository,
    val dispatcher: CoroutineDispatcher
) {

    operator fun invoke(): List<Movie> {
        return repository.getPopularMovies()
    }

}