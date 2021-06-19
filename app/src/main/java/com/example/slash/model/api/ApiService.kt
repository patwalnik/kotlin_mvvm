package com.example.slash.model.api

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {

    @FormUrlEncoded
    @POST("otp")
    fun userLogin(
        @Field("phno") phno: String) : Any


    companion object{
         operator fun invoke() : ApiService{
            return Retrofit.Builder()
                .baseUrl("http://api-stage.xchange.org.in/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService::class.java)
        }
    }
}