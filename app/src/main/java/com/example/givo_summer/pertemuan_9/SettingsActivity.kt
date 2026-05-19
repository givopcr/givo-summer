package com.example.givo_summer.pertemuan_9

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.givo_summer.databinding.ActivitySettingsBinding

class SettingsActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySettingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.toolbar.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        val menuItems = arrayOf(
            "Profil Desa",
            "Kebijakan Privasi",
            "Tentang Aplikasi",
            "Bantuan",
            "Syarat & Ketentuan",
            "Hubungi Pengembang"
        )

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, menuItems)
        binding.listViewSettings.adapter = adapter

        binding.listViewSettings.setOnItemClickListener { _, _, position, _ ->
            val selectedItem = menuItems[position]
            Toast.makeText(this, "Membuka $selectedItem...", Toast.LENGTH_SHORT).show()
        }
    }
}
