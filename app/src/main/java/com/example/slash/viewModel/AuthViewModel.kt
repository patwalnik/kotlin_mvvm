package com.example.slash.viewModel

import android.view.View
import androidx.lifecycle.ViewModel
import com.example.slash.model.api.ApiService
import com.example.slash.model.repository.AuthRepository

class AuthViewModel: ViewModel() {

    private val authRepo = AuthRepository(api = ApiService.invoke())

    var phno : String? = "9717885776"

    suspend fun sendOtp(view : View) {
        println("invoke api");

        val result = authRepo.otpLogin(phno!!)

    }

    suspend fun verifyOtp(view : View) {
        println("invoke api");

        val result = authRepo.otpLogin(phno!!)

    }


}