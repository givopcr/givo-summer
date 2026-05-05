package com.example.givo_summer.pertemuan_4

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.givo_summer.databinding.ActivityDashboardBinding
import com.example.givo_summer.pertemuan_2.BangunDatarActivity
import com.example.givo_summer.pertemuan_3.LoginActivity
import com.google.android.material.snackbar.Snackbar

class DashboardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.cardBangunRuang.setOnClickListener {
            val intent = Intent(this, BangunDatarActivity::class.java).apply {
                putExtra("EXTRA_TITLE", "Bangun Ruang")
                putExtra("EXTRA_DESC", "Halaman ini digunakan untuk menghitung volume bangun ruang (Kubus) dan luas bangun datar.")
            }
            startActivity(intent)
        }

        binding.cardCustom1.setOnClickListener {
            navigateToDetail("Custom Menu 1", "Ini adalah deskripsi untuk Custom Menu 1 yang dikirim dari Dashboard.")
        }

        binding.cardCustom2.setOnClickListener {
            navigateToDetail("Custom Menu 2", "Halaman ini menunjukkan implementasi pengiriman data antar Activity untuk Custom Menu 2.")
        }

        binding.cardLogout.setOnClickListener {
            showLogoutConfirmation()
        }
    }

    private fun navigateToDetail(title: String, desc: String) {
        val intent = Intent(this, DetailActivity::class.java).apply {
            putExtra("EXTRA_TITLE", title)
            putExtra("EXTRA_DESC", desc)
        }
        startActivity(intent)
    }

    private fun showLogoutConfirmation() {
        AlertDialog.Builder(this)
            .setTitle("Konfirmasi Logout")
            .setMessage("Apakah Anda yakin ingin logout?")
            .setPositiveButton("Ya") { _, _ ->
                val intent = Intent(this, LoginActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
                finish()
            }
            .setNegativeButton("Tidak") { _, _ ->
                Snackbar.make(binding.root, "Logout dibatalkan", Snackbar.LENGTH_SHORT).show()
            }
            .show()
    }
}
