package com.example.givo_summer.pertemuan_11.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.givo_summer.databinding.ItemBerita11Binding
import com.example.givo_summer.pertemuan_11.data.model.BeritaModel

class BeritaAdapter(private val items: List<BeritaModel>) : RecyclerView.Adapter<BeritaAdapter.BeritaViewHolder>() {

    class BeritaViewHolder(val binding: ItemBerita11Binding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeritaViewHolder {
        val binding = ItemBerita11Binding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BeritaViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BeritaViewHolder, position: Int) {
        val item = items[position]
        holder.binding.tvBeritaJudul.text = item.judul
        holder.binding.tvBeritaIsi.text = item.isi
    }

    override fun getItemCount(): Int = items.size
}