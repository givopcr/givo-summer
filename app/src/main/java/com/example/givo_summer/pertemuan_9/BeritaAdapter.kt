package com.example.givo_summer.pertemuan_9

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.givo_summer.databinding.ItemBeritaBinding

class BeritaAdapter(
    private val list: List<Berita>,
    private val onClick: (Berita) -> Unit
) : RecyclerView.Adapter<BeritaAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemBeritaBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemBeritaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        with(holder.binding) {
            tvJudul.text = item.judul
            tvMeta.text = "Oleh: ${item.penulis} • ${item.terbitAt}"
            // Kategori label logic can be added here
            
            Glide.with(holder.itemView.context)
                .load(item.coverUrl)
                .into(ivCover)

            root.setOnClickListener { onClick(item) }
        }
    }

    override fun getItemCount(): Int = list.size
}
