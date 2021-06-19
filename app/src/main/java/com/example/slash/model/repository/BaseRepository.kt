package com.example.slash.model.repository

import com.example.slash.model.api.ApiResponse
import com.example.slash.model.api.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher
import retrofit2.HttpException

abstract class BaseRepository {

        suspend fun<T> safeApiCall(
            ApiService : suspend () -> T
        ): ApiResponse<T>{
            return withContext(Dispatchers.IO){
                try {
                    ApiResponse.Success(ApiService.invoke())
                } catch (throwable: Throwable) {
                    when(throwable){
                        is HttpException -> {
                            ApiResponse.Failure(false, throwable.code(), throwable.response()?.errorBody())
                        }
                        else -> {
                            ApiResponse.Failure(true, null, null)
                        }
                    }
                }
            }
        }

}