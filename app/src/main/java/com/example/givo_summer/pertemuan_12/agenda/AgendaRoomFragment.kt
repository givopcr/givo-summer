package com.example.givo_summer.pertemuan_12.agenda

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.givo_summer.databinding.FragmentAgendaRoomBinding
import com.example.givo_summer.pertemuan_12.data.AppDatabase
import com.example.givo_summer.pertemuan_12.data.entity.AgendaEntity
import kotlinx.coroutines.launch

class AgendaRoomFragment : Fragment() {
    private var _binding: FragmentAgendaRoomBinding? = null
    private val binding get() = _binding!!
    private lateinit var db: AppDatabase
    private val listAgenda = mutableListOf<AgendaEntity>()
    private lateinit var adapter: AgendaRoomAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentAgendaRoomBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        db = AppDatabase.getInstance(requireContext())
        
        adapter = AgendaRoomAdapter(listAgenda)
        binding.rvAgenda.layoutManager = LinearLayoutManager(requireContext())
        binding.rvAgenda.adapter = adapter

        binding.fabAddAgenda.setOnClickListener {
            startActivity(Intent(requireContext(), AgendaFormActivity::class.java))
        }

        fetchAgenda()
    }

    private fun fetchAgenda() {
        lifecycleScope.launch {
            val data = db.agendaDao().getAllAgenda()
            listAgenda.clear()
            listAgenda.addAll(data)
            adapter.notifyDataSetChanged()
        }
    }

    override fun onResume() {
        super.onResume()
        fetchAgenda()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}