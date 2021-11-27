package com.gamecast.data.di

import com.gamecast.data.local.MoviesLocalDataSource
import com.gamecast.data.remote.MoviesApi
import com.gamecast.data.remote.MoviesRemoteDataSource
import com.gamecast.data.repository.MoviesDataSource
import com.gamecast.data.repository.MoviesRepositoryImpl
import com.gamecast.domain.repository.MoviesRepository
import dagger.Module
import dagger.Provides
import javax.inject.Qualifier
import javax.inject.Singleton

@Module(includes = [
    DataBindModule::class,
    NetworkModule::class
])
object DataModule {

    enum class Source {
        LOCAL, REMOTE
    }

    @Qualifier
    @MustBeDocumented
    @Retention(AnnotationRetention.RUNTIME)
    annotation class SourceType(val value: Source)

    @JvmStatic
    @SourceType(Source.LOCAL)
    @Provides
    fun providesMoviesLocalDataSource(): MoviesDataSource {
        return MoviesLocalDataSource()
    }

    @JvmStatic
    @SourceType(Source.REMOTE)
    @Provides
    fun providesMoviesRemoteDataSource(
        api: MoviesApi
    ): MoviesDataSource {
        return MoviesRemoteDataSource(api)
    }
}