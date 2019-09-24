package com.nostereal.universityschedule.network

sealed class Result<out T : Any> {
    data class Success<out T : Any>(val data: T) : Result<T>()
    data class Failure(val message: String, val cause: Exception? = null) : Result<Nothing>()
}