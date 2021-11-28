package com.gamecast.domain.di

import com.gamecast.domain.repository.MoviesRepository
import com.gamecast.domain.usecase.GetPopularMoviesUseCase
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton

@Module
object DomainModule {

    @Singleton
    @Provides
    fun provideGetPopularMovies(
        moviesRepository: MoviesRepository,
        dispatcher: CoroutineDispatcher
    ): GetPopularMoviesUseCase {
        return GetPopularMoviesUseCase(moviesRepository, dispatcher)
    }

}