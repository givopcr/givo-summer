package com.example.givo_summer.pertemuan_9

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.givo_summer.databinding.ItemAgendaBinding

class AgendaAdapter(
    private val list: List<Agenda>,
    private val onClick: (Agenda) -> Unit
) : RecyclerView.Adapter<AgendaAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemAgendaBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemAgendaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        with(holder.binding) {
            tvJudul.text = item.judul
            tvLokasi.text = "Lokasi: ${item.lokasi}"
            tvTanggal.text = "Waktu: ${item.tanggalMulai} - ${item.tanggalSelesai}"
            tvPenyelenggara.text = "Penyelenggara: ${item.penyelenggara}"
            
            Glide.with(holder.itemView.context)
                .load(item.posterUrl)
                .into(ivPoster)

            root.setOnClickListener { onClick(item) }
        }
    }

    override fun getItemCount(): Int = list.size
}
