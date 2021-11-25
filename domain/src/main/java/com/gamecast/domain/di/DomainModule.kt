package com.gamecast.domain.di

import com.gamecast.domain.repository.MoviesRepository
import com.gamecast.domain.usecase.GetPopularMoviesUseCase
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher

@Module
object DomainModule {

    @Provides
    fun provideGetPopularMovies(
        moviesRepository: MoviesRepository,
        dispatcher: CoroutineDispatcher
    ): GetPopularMoviesUseCase {
        return GetPopularMoviesUseCase(moviesRepository, dispatcher)
    }

}