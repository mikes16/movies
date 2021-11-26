package com.gamecast.movies.home

import android.util.Log
import androidx.lifecycle.ViewModel
import com.gamecast.domain.usecase.GetPopularMoviesUseCase
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val getPopularMovies: GetPopularMoviesUseCase
): ViewModel() {

    fun loadMovies() {
        Log.d("Miguel", "Loading Movies from Repo: ${getPopularMovies()}")
    }

}