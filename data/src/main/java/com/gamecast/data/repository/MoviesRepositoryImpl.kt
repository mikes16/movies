package com.gamecast.data.repository

import android.util.Log
import com.gamecast.data.di.DataModule.Source
import com.gamecast.data.di.DataModule.SourceType
import com.gamecast.domain.models.Movie
import com.gamecast.domain.repository.MoviesRepository
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(
    @SourceType(Source.LOCAL) private val local: MoviesDataSource,
    @SourceType(Source.REMOTE) private val remote: MoviesDataSource
) : MoviesRepository {

    override fun getPopularMovies(): List<Movie> {
        Log.d("Miguel", "MoviesFrom local ${local.getPopularMovies()}")
        Log.d("Miguel", "MoviesFrom remote ${remote.getPopularMovies()}")
        return listOf(Movie(title = "Test Title"))
    }
}