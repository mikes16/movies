package com.gamecast.movies.di

import com.gamecast.movies.home.HomeFragment
import dagger.Component

@Component
interface AppComponent {
    fun inject(fragment: HomeFragment)
}