package com.gamecast.data.repository

import android.util.Log
import com.gamecast.data.di.DataModule.Source
import com.gamecast.data.di.DataModule.SourceType
import com.gamecast.domain.models.Movies
import com.gamecast.domain.repository.MoviesRepository
import com.gamecast.utils.Failure
import com.gamecast.utils.Result
import com.gamecast.utils.onSuccess
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(
    @SourceType(Source.LOCAL) private val local: MoviesDataSource,
    @SourceType(Source.REMOTE) private val remote: MoviesDataSource,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : MoviesRepository {

    override suspend fun getPopularMovies(): Flow<Result<Failure, Movies>> {
        return flow {
            emit(Result.Loading)
            val result = remote.getPopularMovies()
            if (result.isSuccess) {
                result.onSuccess {
                    Log.d("Miguel", "MoviesFrom remote $it")
                }
            }
            emit(result)
        }.flowOn(dispatcher)
    }
}