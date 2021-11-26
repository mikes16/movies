package com.gamecast.movies.home.di

import androidx.lifecycle.ViewModel
import com.gamecast.movies.di.annotations.ViewModelKey
import com.gamecast.movies.home.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class HomeModule {

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindViewModel(viewModel: HomeViewModel): ViewModel
}