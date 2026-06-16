package com.example.givo_summer.pertemuan_12.aspirasi

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.givo_summer.databinding.ActivityAspirasiFormBinding
import com.example.givo_summer.pertemuan_12.data.AppDatabase
import com.example.givo_summer.pertemuan_12.data.entity.AspirasiEntity
import kotlinx.coroutines.launch

class AspirasiFormActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAspirasiFormBinding
    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAspirasiFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = AppDatabase.getInstance(this)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.toolbar.setNavigationOnClickListener { finish() }

        binding.btnSave.setOnClickListener {
            val judul = binding.etTitle.text.toString()
            val isi = binding.etContent.text.toString()

            if (judul.isNotBlank() && isi.isNotBlank()) {
                lifecycleScope.launch {
                    val aspirasi = AspirasiEntity(
                        judul = judul,
                        isi = isi,
                        createdAt = System.currentTimeMillis()
                    )
                    db.aspirasiDao().insertAspirasi(aspirasi)
                    Toast.makeText(this@AspirasiFormActivity, "Aspirasi terkirim!", Toast.LENGTH_SHORT).show()
                    finish()
                }
            } else {
                Toast.makeText(this, "Mohon lengkapi semua data", Toast.LENGTH_SHORT).show()
            }
        }
    }
}