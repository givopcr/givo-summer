package com.example.givo_summer.pertemuan_11.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.givo_summer.databinding.FragmentHome11Binding
import com.example.givo_summer.pertemuan_11.data.api.BeritaApiClient
import com.example.givo_summer.pertemuan_11.data.api.GaleriApiClient
import com.example.givo_summer.pertemuan_11.home.photo.GaleriAdapter
import com.example.givo_summer.pertemuan_12.agenda.AgendaFormActivity
import com.example.givo_summer.pertemuan_12.aspirasi.AspirasiFormActivity
import kotlinx.coroutines.launch

class HomeFragment11 : Fragment() {

    private var _binding: FragmentHome11Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHome11Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.cardAspirasi.setOnClickListener {
            startActivity(Intent(requireContext(), AspirasiFormActivity::class.java))
        }

        binding.cardAgenda.setOnClickListener {
            startActivity(Intent(requireContext(), AgendaFormActivity::class.java))
        }

        loadBerita()
        loadGaleri()
    }

    private fun loadBerita() {
        lifecycleScope.launch {
            try {
                val response = BeritaApiClient.apiService.getBerita()
                val adapter = BeritaAdapter(response)
                binding.rvBerita.adapter = adapter
                binding.rvBerita.layoutManager = LinearLayoutManager(requireContext())
            } catch (e: Exception) {
                Toast.makeText(requireContext(), "Gagal memuat berita", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun loadGaleri() {
        lifecycleScope.launch {
            try {
                val photos = GaleriApiClient.apiService.getGaleri()
                val adapter = GaleriAdapter(photos)
                binding.rvGallery.adapter = adapter
                binding.rvGallery.layoutManager = LinearLayoutManager(requireContext())
            } catch (e: Exception) {
                Toast.makeText(requireContext(), "Gagal memuat galeri desa", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}