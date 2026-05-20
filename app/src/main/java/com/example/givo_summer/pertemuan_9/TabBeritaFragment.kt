package com.example.givo_summer.pertemuan_9

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.givo_summer.databinding.FragmentTabBeritaBinding

class TabBeritaFragment : Fragment() {
    private var _binding: FragmentTabBeritaBinding? = null
    private val binding get() = _binding!!

    private val beritaList = listOf(
        Berita(1, 1, "Pembangunan Jembatan Desa Selesai", "pembangunan-jembatan-desa-selesai", "<p>Isi berita...</p>", "Admin", "Terbit", "2023-10-01", "https://picsum.photos/seed/berita1/400/300"),
        Berita(2, 2, "Panen Raya Padi Organik", "panen-raya-padi-organik", "<p>Isi berita...</p>", "Admin", "Terbit", "2023-10-05", "https://picsum.photos/seed/berita2/400/300"),
        Berita(3, 1, "Pelatihan Digital Marketing UMKM", "pelatihan-digital-marketing-umkm", "<p>Isi berita...</p>", "Admin", "Terbit", "2023-10-10", "https://picsum.photos/seed/berita3/400/300")
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentTabBeritaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = BeritaAdapter(beritaList) { item ->
            Toast.makeText(requireContext(), "Berita: ${item.judul}", Toast.LENGTH_SHORT).show()
        }
        binding.rvBerita.layoutManager = LinearLayoutManager(requireContext())
        binding.rvBerita.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
