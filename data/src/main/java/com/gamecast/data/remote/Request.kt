package com.gamecast.data.remote

import android.util.Log
import com.gamecast.utils.Failure
import com.gamecast.utils.Result
import retrofit2.HttpException
import retrofit2.Response

fun <T> Response<T>.request(default: T): Result<Failure, T> {
    return try {
        when (isSuccessful) {
            true -> Result.Success(body() ?: default)
            false -> Result.Failure(Failure.ServerError(HttpException(this)))
                .also { Log.w("Network", "Unsuccessful response: $this") }
        }
    } catch (exception: Throwable) {
        exception.printStackTrace()
        Result.Failure(Failure.ServerError(exception))
    }
}