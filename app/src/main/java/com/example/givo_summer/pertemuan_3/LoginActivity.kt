package com.example.givo_summer.pertemuan_3

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.givo_summer.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            val username = binding.etEmail.text.toString().trim()
            val password = binding.etPassword.text.toString()

            // Reset errors
            binding.etEmail.error = null
            binding.etPassword.error = null

            if (username.isEmpty()) {
                binding.etEmail.error = "Username tidak boleh kosong"
                return@setOnClickListener
            }

            if (password.isEmpty()) {
                binding.etPassword.error = "Password tidak boleh kosong"
                return@setOnClickListener
            }

            // Ambil data dari SharedPreferences (hasil registrasi)
            val userPrefs = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
            val savedUsername = userPrefs.getString("username", null)
            val savedPassword = userPrefs.getString("password", null)

            // Rule Login:
            // 1. username == password
            // 2. username == savedUsername && password == savedPassword
            val isRule1Success = username == password
            val isRule2Success = savedUsername != null && username == savedUsername && password == savedPassword

            if (isRule1Success || isRule2Success) {
                // Save login state
                val sharedPref = getSharedPreferences("BinaDesaPrefs", Context.MODE_PRIVATE)
                with(sharedPref.edit()) {
                    putBoolean("isLogin", true)
                    apply()
                }

                val intent = Intent(this, com.example.givo_summer.pertemuan_7.MainNavigationActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                binding.etEmail.error = "Username atau Password salah"
                binding.etPassword.error = "Username atau Password salah"
            }
        }

        binding.tvRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}
