package com.gamecast.movies.home

import androidx.lifecycle.ViewModel
import com.gamecast.domain.usecase.GetPopularMoviesUseCase
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    val getPopularMovies: GetPopularMoviesUseCase
): ViewModel() {

}