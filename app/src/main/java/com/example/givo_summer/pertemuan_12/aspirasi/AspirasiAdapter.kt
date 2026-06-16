package com.example.givo_summer.pertemuan_12.aspirasi

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.givo_summer.databinding.ItemAspirasiBinding
import com.example.givo_summer.pertemuan_12.data.entity.AspirasiEntity
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class AspirasiAdapter(
    private val items: List<AspirasiEntity>,
    private val onNoteDelete: (AspirasiEntity) -> Unit
) : RecyclerView.Adapter<AspirasiAdapter.AspirasiViewHolder>() {

    class AspirasiViewHolder(val binding: ItemAspirasiBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AspirasiViewHolder {
        val binding = ItemAspirasiBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AspirasiViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AspirasiViewHolder, position: Int) {
        val item = items[position]
        holder.binding.tvTitle.text = item.judul
        holder.binding.tvContent.text = item.isi

        holder.binding.btnDelete.setOnClickListener {
            MaterialAlertDialogBuilder(holder.itemView.context)
                .setTitle("Hapus Aspirasi")
                .setMessage("Yakin ingin menghapus aspirasi ini?")
                .setPositiveButton("Ya") { _, _ ->
                    onNoteDelete(item)
                }
                .setNegativeButton("Batal", null)
                .show()
        }
    }

    override fun getItemCount(): Int = items.size
}