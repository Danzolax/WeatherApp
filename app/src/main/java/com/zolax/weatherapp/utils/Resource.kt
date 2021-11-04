package com.zolax.weatherapp.utils

sealed class Resource<T>(val data: T?, val error: Throwable?, val msg: String?) {
    class Success<T>(data: T? = null) : Resource<T>(data = data, null, null)
    object Loading : Resource<Unit>(null, null, null)
    class Error<T>(
        error: Throwable? = null,
        msg: String? = null,
    ) : Resource<T>(data = null, error, msg)
}