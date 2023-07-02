package com.taylorm.s169382.data

import com.taylorm.s169382.data.local.NoInternetException
import java.io.IOException

/*
Sealed class representing the different states of a data resource.
 */
sealed class DataResource<out R> {
    data class Success<out T>(val data: T) : DataResource<T>()
    object Empty : DataResource<Nothing>()
    data class Error<out T>(val exception: Throwable) : DataResource<Nothing>()
    object Loading : DataResource<Nothing>()

    /*
    Overrides the toString function to return a string representation of the data resource.
     */
    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error<*> -> "Error[exception=$exception]"
            is Empty -> "Empty"
            Loading -> "Loading"
        }
    }
}

/*
Returns the data if the data resource is a success, otherwise returns the fallback value.
 */
fun <T> DataResource<T>.successOr(fallback: T): T {
    return (this as? DataResource.Success<T>)?.data ?: fallback
}

/*
Returns true if the data resource is a success, otherwise returns false.
 */
fun <T> DataResource<T>.succeeded(): Boolean {
    return this is DataResource.Success<T>
}

/*
Extension property to return the data if the data resource is a success, otherwise returns null.
 */
val <T> DataResource<T>.data: T?
    get() = (this as? DataResource.Success<T>)?.data

/*
Extension function to check if a value is an empty response.
 */
fun <T> T.isEmptyResponse(): Boolean {
    return this != null && this is List<*> && this.isEmpty()
}

/*
Suspended function to make an API call and wrap the response in a data resource.
 */
suspend fun <T> callApi(apiCall: suspend () -> T): DataResource<T> {
    return try {
        val response = apiCall.invoke()
        if (response.isEmptyResponse()) {
            DataResource.Empty
        } else {
            DataResource.Success(response)
        }
    } catch (throwable: Throwable) {
        when (throwable) {
            is IOException -> DataResource.Error<Any>(NoInternetException())
            else -> DataResource.Error<Any>(throwable)
        }
    }
}

/*
Extension function to execute a block of code if the data resource is a success.
 */
fun <T> DataResource<T>.onSuccess(
    onResult: DataResource.Success<T>.() -> Unit
): DataResource<T> {
    if (this is DataResource.Success) {
        onResult(this)
    }
    return this
}

/*
Extension function to execute a block of code if the data resource is an error.
 */
fun <T> DataResource<T>.onError(
    onResult: DataResource.Error<T>.() -> Unit
): DataResource<T> {
    if (this is DataResource.Error<*>) {
        onResult(this as DataResource.Error<T>)
    }
    return this
}

/*
Extension function to execute a block of code if the data resource is empty.
 */
fun <T> DataResource<T>.onEmpty(
    onResult: DataResource.Empty.() -> Unit
): DataResource<T> {
    if (this is DataResource.Empty) {
        onResult(this)
    }
    return this
}

/*
Extension function to execute a block of code if the data resource is loading.
 */
fun <T> DataResource<T>.onLoading(
    onResult: DataResource.Loading.() -> Unit
): DataResource<T> {
    if (this is DataResource.Loading) {
        onResult(this)
    }
    return this
}