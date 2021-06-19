package com.example.slash.model.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.slash.model.api.ApiService
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuthRepository(
    private val api: ApiService
) : BaseRepository() {

    private val apiService = ApiService()

   suspend fun otpLogin(phno: String) = safeApiCall {
        api.userLogin(phno)
    }

    suspend fun verifyLogin(phno: String) = safeApiCall {
        api.userLogin(phno)
    }
}


