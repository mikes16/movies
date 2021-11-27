package com.gamecast.utils

sealed class Failure {
    data class ServerError(val throws: Throwable) : Failure()
}