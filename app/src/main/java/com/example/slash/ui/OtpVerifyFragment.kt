package com.example.slash.ui

import android.os.Bundle
import android.util.Log
import android.view.View

import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.slash.R
import com.example.slash.viewModel.AuthViewModel
import com.example.slash.viewModel.MainViewModelFactory
import kotlinx.coroutines.launch

class OtpVerifyFragment : AppCompatActivity() {

    private lateinit var viewModel: AuthViewModel
    private lateinit var sendOtpButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        viewModel = AuthViewModel()
        val otpBtn = findViewById<Button>(R.id.sendOtpBtn) as Button
//        val visPhno = findViewById<Button>(R.id.auth_phone_number) as EditText


        val application = requireNotNull(this).application
        val factory = MainViewModelFactory()


        ViewModelProvider(this).get(viewModel!!::class.java)

        otpBtn.setOnClickListener {
            lifecycleScope.launch {
                viewModel!!.sendOtp(it)

            }
        }
    }
}