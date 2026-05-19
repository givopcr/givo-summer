package com.example.givo_summer.pertemuan_9

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
//import com.example.givo_summer.databinding.ActivityPertemuan9Binding

class Pertemuan9Activity : AppCompatActivity() {

    private lateinit var binding: ActivityPertemuan9Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPertemuan9Binding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.toolbar.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        binding.btnKirim.setOnClickListener {
            val nama = binding.tilNama.editText?.text.toString()
            if (nama.isNotEmpty()) {
                Toast.makeText(this, "Terima kasih $nama, feedback Anda telah terkirim!", Toast.LENGTH_SHORT).show()
                binding.tilNama.editText?.text?.clear()
                binding.tilPesan.editText?.text?.clear()
            } else {
                binding.tilNama.error = "Mohon isi nama Anda"
            }
        }

        binding.btnSettings.setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
        }

        binding.chipGroupFokus.setOnCheckedStateChangeListener { group, checkedIds ->
            if (checkedIds.isNotEmpty()) {
                val chipText = when (checkedIds[0]) {
                    else -> "Kategori dipilih"
                }
            }
        }
    }
}
