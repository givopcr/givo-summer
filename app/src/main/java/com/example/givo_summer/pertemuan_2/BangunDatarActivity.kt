package com.example.givo_summer.pertemuan_2

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.givo_summer.R

class BangunDatarActivity : AppCompatActivity() {

    private lateinit var etAlas: EditText
    private lateinit var etTinggi: EditText
    private lateinit var btnHitungSegitiga: Button
    private lateinit var tvHasilSegitiga: TextView

    private lateinit var etSisi: EditText
    private lateinit var btnHitungKubus: Button
    private lateinit var tvHasilKubus: TextView

    private lateinit var tvTitle: TextView
    private lateinit var tvDesc: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bangun_datar)

        Log.d("BangunDatarActivity", "Activity Created - Mempelajari Logcat")

        // Inisialisasi View Segitiga
        etAlas = findViewById(R.id.et_alas)
        etTinggi = findViewById(R.id.et_tinggi)
        btnHitungSegitiga = findViewById(R.id.btn_hitung_segitiga)
        tvHasilSegitiga = findViewById(R.id.tv_hasil_segitiga)

        // Inisialisasi View Kubus
        etSisi = findViewById(R.id.et_sisi)
        btnHitungKubus = findViewById(R.id.btn_hitung_kubus)
        tvHasilKubus = findViewById(R.id.tv_hasil_kubus)

        tvTitle = findViewById(R.id.tv_title)
        tvDesc = findViewById(R.id.tv_desc)

        val title = intent.getStringExtra("EXTRA_TITLE") ?: "Bangun Datar & Ruang"
        val desc = intent.getStringExtra("EXTRA_DESC") ?: "Hitung luas dan volume"

        tvTitle.text = title
        tvDesc.text = desc

        // Event Klik Hitung Segitiga
        btnHitungSegitiga.setOnClickListener {
            hitungLuasSegitiga()
        }

        // Event Klik Hitung Kubus
        btnHitungKubus.setOnClickListener {
            hitungVolumeKubus()
        }
    }

    private fun hitungLuasSegitiga() {
        val alasStr = etAlas.text.toString()
        val tinggiStr = etTinggi.text.toString()

        if (alasStr.isNotEmpty() && tinggiStr.isNotEmpty()) {
            val alas = alasStr.toDouble()
            val tinggi = tinggiStr.toDouble()
            val luas = 0.5 * alas * tinggi
            
            tvHasilSegitiga.text = "Hasil: $luas"
            Log.i("BangunDatarActivity", "Menghitung Luas Segitiga: 0.5 * $alas * $tinggi = $luas")
        } else {
            Toast.makeText(this, "Mohon isi alas dan tinggi", Toast.LENGTH_SHORT).show()
            Log.w("BangunDatarActivity", "Input Segitiga Kosong!")
        }
    }

    private fun hitungVolumeKubus() {
        val sisiStr = etSisi.text.toString()

        if (sisiStr.isNotEmpty()) {
            val sisi = sisiStr.toDouble()
            val volume = sisi * sisi * sisi
            
            tvHasilKubus.text = "Hasil: $volume"
            Log.i("BangunDatarActivity", "Menghitung Volume Kubus: $sisi^3 = $volume")
        } else {
            Toast.makeText(this, "Mohon isi panjang sisi", Toast.LENGTH_SHORT).show()
            Log.w("BangunDatarActivity", "Input Kubus Kosong!")
        }
    }
}
