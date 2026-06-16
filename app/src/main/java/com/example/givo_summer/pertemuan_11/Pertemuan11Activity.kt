package com.example.givo_summer.pertemuan_11

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.givo_summer.R
import com.example.givo_summer.databinding.ActivityPertemuan11Binding
import com.google.android.material.tabs.TabLayoutMediator

class Pertemuan11Activity : AppCompatActivity() {

    private lateinit var binding: ActivityPertemuan11Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPertemuan11Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = Pertemuan11TabsAdapter(this)
        binding.viewPager.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Beranda"
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