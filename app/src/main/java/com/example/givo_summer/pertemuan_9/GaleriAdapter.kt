package com.example.givo_summer.pertemuan_9

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.givo_summer.databinding.ItemGaleriBinding

class GaleriAdapter(
    private val list: List<Galeri>,
    private val onClick: (Galeri) -> Unit
) : RecyclerView.Adapter<GaleriAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemGaleriBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemGaleriBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        with(holder.binding) {
            tvJudul.text = item.judul
            
            Glide.with(holder.itemView.context)
                .load(item.fotoUrl)
                .into(ivFoto)

            root.setOnClickListener { onClick(item) }
        }
    }

    override fun getItemCount(): Int = list.size
}
