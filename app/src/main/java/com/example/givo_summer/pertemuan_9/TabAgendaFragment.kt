package com.example.givo_summer.pertemuan_9

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.givo_summer.databinding.FragmentTabAgendaBinding

class TabAgendaFragment : Fragment() {
    private var _binding: FragmentTabAgendaBinding? = null
    private val binding get() = _binding!!

    private val agendaList = listOf(
        Agenda(1, "Rapat Koordinasi Desa", "Balai Desa Sukamaju", "15 Okt 2023", "15 Okt 2023", "Sekretariat Desa", "Pembahasan rencana pembangunan tahunan.", "https://picsum.photos/seed/agenda1/400/300"),
        Agenda(2, "Festival Budaya Lokal", "Lapangan Utama", "20 Okt 2023", "22 Okt 2023", "Karang Taruna", "Menampilkan kesenian daerah dan pasar rakyat.", "https://picsum.photos/seed/agenda2/400/300"),
        Agenda(3, "Posyandu Balita", "Posyandu Mawar", "25 Okt 2023", "25 Okt 2023", "PKK Desa", "Pemeriksaan kesehatan rutin untuk balita.", "https://picsum.photos/seed/agenda3/400/300")
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentTabAgendaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = AgendaAdapter(agendaList) { item ->
            Toast.makeText(requireContext(), "Agenda: ${item.judul}", Toast.LENGTH_SHORT).show()
        }
        binding.rvAgenda.layoutManager = LinearLayoutManager(requireContext())
        binding.rvAgenda.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
