package com.example.givo_summer.pertemuan_12.aspirasi

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.givo_summer.databinding.FragmentAspirasiBinding
import com.example.givo_summer.pertemuan_12.data.AppDatabase
import com.example.givo_summer.pertemuan_12.data.entity.AspirasiEntity
import kotlinx.coroutines.launch

class AspirasiFragment : Fragment() {
    private var _binding: FragmentAspirasiBinding? = null
    private val binding get() = _binding!!
    private lateinit var db: AppDatabase
    private val listAspirasi = mutableListOf<AspirasiEntity>()
    private lateinit var adapter: AspirasiAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentAspirasiBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        db = AppDatabase.getInstance(requireContext())
        
        adapter = AspirasiAdapter(listAspirasi) { aspirasi ->
            deleteAspirasi(aspirasi)
        }
        
        binding.rvAspirasi.layoutManager = LinearLayoutManager(requireContext())
        binding.rvAspirasi.adapter = adapter

        binding.fabAddAspirasi.setOnClickListener {
            startActivity(Intent(requireContext(), AspirasiFormActivity::class.java))
        }

        fetchAspirasi()
    }

    private fun fetchAspirasi() {
        lifecycleScope.launch {
            val data = db.aspirasiDao().getAllAspirasi()
            listAspirasi.clear()
            listAspirasi.addAll(data)
            adapter.notifyDataSetChanged()
        }
    }

    private fun deleteAspirasi(aspirasi: AspirasiEntity) {
        lifecycleScope.launch {
            db.aspirasiDao().deleteAspirasi(aspirasi)
            fetchAspirasi()
        }
    }

    override fun onResume() {
        super.onResume()
        fetchAspirasi()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}