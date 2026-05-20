package com.example.givo_summer.pertemuan_9

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.givo_summer.R
import com.example.givo_summer.databinding.ActivityPertemuan9Binding
import com.google.android.material.tabs.TabLayoutMediator

class Pertemuan9Activity : AppCompatActivity() {

    private lateinit var binding: ActivityPertemuan9Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPertemuan9Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Setup Toolbar
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            title = "Portal Desa Digital"
            setDisplayHomeAsUpEnabled(true)
        }
        binding.toolbar.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        // 1. Inisialisasi Adapter
        val tabsAdapter = Pertemuan9TabsAdapter(this)

        // 2. Set adapter ke ViewPager2
        binding.viewPager.adapter = tabsAdapter

        // 3. Hubungkan TabLayout & ViewPager2 menggunakan TabLayoutMediator
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Profil"
                    tab.icon = ContextCompat.getDrawable(this, R.drawable.ic_logo)
                }
                1 -> {
                    tab.text = "Berita"
                    tab.icon = ContextCompat.getDrawable(this, R.drawable.ic_logo)
                }
                2 -> {
                    tab.text = "Agenda"
                    tab.icon = ContextCompat.getDrawable(this, R.drawable.ic_logo)
                }
                3 -> {
                    tab.text = "Galeri"
                    tab.icon = ContextCompat.getDrawable(this, R.drawable.ic_logo)
                }
            }
        }.attach()
    }
}
