package com.example.givo_summer.pertemuan_11.home.photo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.givo_summer.databinding.ItemPhotoBinding
import com.example.givo_summer.pertemuan_11.data.model.GaleriModel

class GaleriAdapter(private val items: List<GaleriModel>) : RecyclerView.Adapter<GaleriAdapter.GaleriViewHolder>() {

    class GaleriViewHolder(val binding: ItemPhotoBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GaleriViewHolder {
        val binding = ItemPhotoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GaleriViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GaleriViewHolder, position: Int) {
        val item = items[position]
        holder.binding.tvAuthor.text = item.penulis
        Glide.with(holder.itemView.context)
            .load(item.fotoUrl)
            .into(holder.binding.imgPhoto)
    }

    override fun getItemCount(): Int = items.size
}