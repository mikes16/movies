package com.gamecast.movies.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gamecast.domain.models.Movies
import com.gamecast.domain.usecase.GetPopularMoviesUseCase
import com.gamecast.utils.Failure
import com.gamecast.utils.Result
import com.gamecast.utils.onLoading
import com.gamecast.utils.onSuccess
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val getPopularMovies: GetPopularMoviesUseCase
): ViewModel() {

    val postStateFlow: StateFlow<Result<Failure, Movies>> = flow {
        getPopularMovies().collect { emit(it) }
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = Result.Loading
    )

}