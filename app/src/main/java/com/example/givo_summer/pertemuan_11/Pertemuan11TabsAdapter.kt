package com.example.givo_summer.pertemuan_11

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.givo_summer.pertemuan_11.home.HomeFragment11
import com.example.givo_summer.pertemuan_11.message.MessageFragment11

class Pertemuan11TabsAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> HomeFragment11()
            else -> MessageFragment11()
        }
    }
}