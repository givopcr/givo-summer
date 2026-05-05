package com.example.givo_summer.pertemuan_3

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.givo_summer.databinding.ActivityLoginBinding
import com.example.givo_summer.pertemuan_4.DashboardActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            // Save login state
            val sharedPref = getSharedPreferences("BinaDesaPrefs", android.content.Context.MODE_PRIVATE)
            with(sharedPref.edit()) {
                putBoolean("isLogin", true)
                apply()
            }

            val intent = Intent(this, com.example.givo_summer.pertemuan_7.MainNavigationActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
