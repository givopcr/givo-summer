package com.example.givo_summer.pertemuan_12.agenda

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.givo_summer.databinding.ActivityAgendaFormBinding
import com.example.givo_summer.pertemuan_12.data.AppDatabase
import com.example.givo_summer.pertemuan_12.data.entity.AgendaEntity
import kotlinx.coroutines.launch

class AgendaFormActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAgendaFormBinding
    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAgendaFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = AppDatabase.getInstance(this)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.toolbar.setNavigationOnClickListener { finish() }

        binding.btnSaveAgenda.setOnClickListener {
            val judul = binding.etJudul.text.toString()
            val lokasi = binding.etLokasi.text.toString()
            val waktu = binding.etWaktu.text.toString()
            val deskripsi = binding.etDeskripsi.text.toString()

            if (judul.isNotBlank() && lokasi.isNotBlank()) {
                lifecycleScope.launch {
                    val agenda = AgendaEntity(
                        judul = judul,
                        lokasi = lokasi,
                        waktu = waktu,
                        deskripsi = deskripsi
                    )
                    db.agendaDao().insertAgenda(agenda)
                    Toast.makeText(this@AgendaFormActivity, "Agenda disimpan!", Toast.LENGTH_SHORT).show()
                    finish()
                }
            } else {
                Toast.makeText(this, "Judul dan Lokasi wajib diisi", Toast.LENGTH_SHORT).show()
            }
        }
    }
}