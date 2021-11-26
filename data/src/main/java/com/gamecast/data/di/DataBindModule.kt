package com.gamecast.data.di

import com.gamecast.data.repository.MoviesRepositoryImpl
import com.gamecast.domain.repository.MoviesRepository
import dagger.Binds
import dagger.Module

@Module
abstract class DataBindModule {

    @Binds
    abstract fun bindRepository(repo: MoviesRepositoryImpl): MoviesRepository
}