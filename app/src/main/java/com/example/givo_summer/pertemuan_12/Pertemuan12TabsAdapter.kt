package com.example.givo_summer.pertemuan_12

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.givo_summer.pertemuan_12.home.HomeFragment12
import com.example.givo_summer.pertemuan_12.message.MessageFragment12
import com.example.givo_summer.pertemuan_12.aspirasi.AspirasiFragment
import com.example.givo_summer.pertemuan_12.agenda.AgendaRoomFragment

class Pertemuan12TabsAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> HomeFragment12()
            1 -> AspirasiFragment()
            2 -> AgendaRoomFragment()
            else -> MessageFragment12()
        }
    }
}