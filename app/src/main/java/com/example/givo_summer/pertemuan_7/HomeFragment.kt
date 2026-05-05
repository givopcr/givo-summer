package com.example.givo_summer.pertemuan_7

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.example.givo_summer.databinding.FragmentHomeBinding
import com.example.givo_summer.pertemuan_2.BangunDatarActivity
import com.example.givo_summer.pertemuan_3.LoginActivity
import com.example.givo_summer.pertemuan_4.DetailActivity
import com.example.givo_summer.pertemuan_6.WebViewActivity
import com.google.android.material.snackbar.Snackbar

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.cardBangunRuang.setOnClickListener {
            val intent = Intent(requireContext(), BangunDatarActivity::class.java).apply {
                putExtra("EXTRA_TITLE", "Bangun Ruang")
                putExtra("EXTRA_DESC", "Halaman ini digunakan untuk menghitung volume bangun ruang (Kubus) dan luas bangun datar.")
            }
            startActivity(intent)
        }

        binding.cardWebView.setOnClickListener {
            startActivity(Intent(requireContext(), WebViewActivity::class.java))
        }

        binding.cardCustom1.setOnClickListener {
            navigateToDetail("Custom Menu 1", "Ini adalah deskripsi untuk Custom Menu 1 yang dikirim dari Dashboard.")
        }

        binding.cardCustom2.setOnClickListener {
            navigateToDetail("Custom Menu 2", "Halaman ini menunjukkan implementasi pengiriman data antar Activity untuk Custom Menu 2.")
        }

        binding.btnLogoutAlt.setOnClickListener {
            showLogoutConfirmation()
        }
    }

    private fun navigateToDetail(title: String, desc: String) {
        val intent = Intent(requireContext(), DetailActivity::class.java).apply {
            putExtra("EXTRA_TITLE", title)
            putExtra("EXTRA_DESC", desc)
        }
        startActivity(intent)
    }

    private fun showLogoutConfirmation() {
        AlertDialog.Builder(requireContext())
            .setTitle("Konfirmasi Logout")
            .setMessage("Apakah Anda yakin ingin logout?")
            .setPositiveButton("Ya") { _, _ ->
                val sharedPref = requireActivity().getSharedPreferences("BinaDesaPrefs", Context.MODE_PRIVATE)
                with(sharedPref.edit()) {
                    putBoolean("isLogin", false)
                    apply()
                }

                val intent = Intent(requireContext(), LoginActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
                requireActivity().finish()
            }
            .setNegativeButton("Tidak") { _, _ ->
                Snackbar.make(binding.root, "Logout dibatalkan", Snackbar.LENGTH_SHORT).show()
            }
            .show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
