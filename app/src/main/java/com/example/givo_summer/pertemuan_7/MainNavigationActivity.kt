package com.example.givo_summer.pertemuan_7

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.givo_summer.R
import com.example.givo_summer.databinding.ActivityMainNavigationBinding

class MainNavigationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainNavigationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainNavigationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        // Set default fragment
        loadFragment(HomeFragment())

        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    loadFragment(HomeFragment())
                    binding.toolbar.title = "Bina Desa"
                    true
                }
                R.id.navigation_about -> {
                    loadFragment(AboutFragment())
                    binding.toolbar.title = "Tentang Program"
                    true
                }
                R.id.navigation_profile -> {
                    loadFragment(ProfileFragment())
                    binding.toolbar.title = "Profil Pengembang"
                    true
                }
                else -> false
            }
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment, fragment)
            .commit()
    }
}
