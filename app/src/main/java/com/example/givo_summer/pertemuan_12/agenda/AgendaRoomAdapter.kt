package com.example.givo_summer.pertemuan_12.agenda

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.givo_summer.databinding.ItemAgendaRoomBinding
import com.example.givo_summer.pertemuan_12.data.entity.AgendaEntity

class AgendaRoomAdapter(private val items: List<AgendaEntity>) : RecyclerView.Adapter<AgendaRoomAdapter.AgendaViewHolder>() {

    class AgendaViewHolder(val binding: ItemAgendaRoomBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AgendaViewHolder {
        val binding = ItemAgendaRoomBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AgendaViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AgendaViewHolder, position: Int) {
        val item = items[position]
        holder.binding.tvJudul.text = item.judul
        holder.binding.tvWaktuLokasi.text = "${item.waktu} @ ${item.lokasi}"
        holder.binding.tvDeskripsi.text = item.deskripsi
    }

    override fun getItemCount(): Int = items.size
}