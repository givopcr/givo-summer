package com.example.givo_summer.pertemuan_12

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.givo_summer.R
import com.example.givo_summer.databinding.ActivityPertemuan11Binding
import com.google.android.material.tabs.TabLayoutMediator

class Pertemuan12Activity : AppCompatActivity() {

    private lateinit var binding: ActivityPertemuan11Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPertemuan11Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = Pertemuan12TabsAdapter(this)
        binding.viewPager.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Beranda"
                    tab.setIcon(R.drawable.ic_logo)
                }
                1 -> {
                    tab.text = "Aspirasi"
                    tab.setIcon(R.drawable.ic_info)
                }
                2 -> {
                    tab.text = "Agenda"
                    tab.setIcon(R.drawable.ic_logo)
                }
                else -> {
                    tab.text = "Pesan"
                    tab.setIcon(R.drawable.ic_logo)
                }
            }
        }.attach()
    }
}