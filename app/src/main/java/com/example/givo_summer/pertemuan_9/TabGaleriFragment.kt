package com.example.givo_summer.pertemuan_9

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.givo_summer.databinding.FragmentTabGaleriBinding

class TabGaleriFragment : Fragment() {
    private var _binding: FragmentTabGaleriBinding? = null
    private val binding get() = _binding!!

    private val galeriList = listOf(
        Galeri(1, "Gotong Royong Kebersihan", "Masyarakat desa membersihkan lingkungan bersama.", "https://picsum.photos/seed/galeri1/400/300"),
        Galeri(2, "Penyaluran Bantuan Sosial", "Pemerintah desa menyalurkan bantuan kepada warga.", "https://picsum.photos/seed/galeri2/400/300"),
        Galeri(3, "Pelatihan Kerajinan Tangan", "Warga belajar membuat kerajinan dari bahan alam.", "https://picsum.photos/seed/galeri3/400/300"),
        Galeri(4, "Lomba HUT RI di Desa", "Kemeriahan peringatan hari kemerdekaan.", "https://picsum.photos/seed/galeri4/400/300"),
        Galeri(5, "Pembangunan Jalan Desa", "Proses pengaspalan jalan lingkungan.", "https://picsum.photos/seed/galeri5/400/300"),
        Galeri(6, "Kunjungan Studi Banding", "Penerimaan tamu dari desa lain.", "https://picsum.photos/seed/galeri6/400/300")
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentTabGaleriBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = GaleriAdapter(galeriList) { item ->
            Toast.makeText(requireContext(), "Galeri: ${item.judul}", Toast.LENGTH_SHORT).show()
        }
        binding.rvGaleri.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.rvGaleri.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
