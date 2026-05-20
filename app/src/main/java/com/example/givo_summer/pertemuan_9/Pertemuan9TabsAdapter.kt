package com.example.givo_summer.pertemuan_9

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class Pertemuan9TabsAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> TabProfilFragment()
            1 -> TabBeritaFragment()
            2 -> TabAgendaFragment()
            3 -> TabGaleriFragment()
            else -> throw IllegalStateException("Posisi tidak valid")
        }
    }
}
