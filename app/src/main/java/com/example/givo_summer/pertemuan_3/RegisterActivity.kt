package com.example.givo_summer.pertemuan_3

import android.app.DatePickerDialog
import android.content.Context
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.givo_summer.databinding.ActivityRegisterBinding
import java.util.*

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupDatePicker()
        setupReligionSpinner()

        binding.btnRegister.setOnClickListener {
            validateAndRegister()
        }

        binding.tvLogin.setOnClickListener {
            finish()
        }
    }

    private fun setupDatePicker() {
        binding.etDob.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(
                this,
                { _, selectedYear, selectedMonth, selectedDay ->
                    val date = "$selectedDay/${selectedMonth + 1}/$selectedYear"
                    binding.etDob.setText(date)
                    binding.etDob.error = null // Clear error when date is selected
                },
                year,
                month,
                day
            )
            datePickerDialog.show()
        }
    }

    private fun setupReligionSpinner() {
        val religions = arrayOf("Pilih Agama", "Islam", "Kristen Protestan", "Katolik", "Hindu", "Buddha", "Khonghucu")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, religions)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spReligion.adapter = adapter
    }

    private fun validateAndRegister() {
        // Reset errors
        binding.etName.error = null
        binding.etDob.error = null
        binding.etUsername.error = null
        binding.etPassword.error = null
        binding.etConfirmPassword.error = null
        binding.rbFemale.error = null

        val name = binding.etName.text.toString().trim()
        val dob = binding.etDob.text.toString().trim()
        val username = binding.etUsername.text.toString().trim()
        val password = binding.etPassword.text.toString()
        val confirmPassword = binding.etConfirmPassword.text.toString()
        
        val selectedGenderId = binding.rgGender.checkedRadioButtonId
        val gender = if (selectedGenderId != -1) {
            findViewById<RadioButton>(selectedGenderId).text.toString()
        } else {
            ""
        }
        
        val religion = binding.spReligion.selectedItem?.toString() ?: ""

        var isValid = true

        if (name.isEmpty()) {
            binding.etName.error = "Nama tidak boleh kosong"
            isValid = false
        }
        
        if (dob.isEmpty()) {
            binding.etDob.error = "Tanggal lahir harus diisi"
            isValid = false
        }

        if (gender.isEmpty()) {
            binding.rbFemale.error = "Jenis kelamin harus dipilih"
            isValid = false
        }

        if (religion == "Pilih Agama" || religion.isEmpty()) {
            // Spinner doesn't have setError, so we'll just check it
            Toast.makeText(this, "Agama harus dipilih", Toast.LENGTH_SHORT).show()
            isValid = false
        }

        if (username.isEmpty()) {
            binding.etUsername.error = "Username tidak boleh kosong"
            isValid = false
        }

        if (password.isEmpty()) {
            binding.etPassword.error = "Password tidak boleh kosong"
            isValid = false
        }

        if (confirmPassword.isEmpty()) {
            binding.etConfirmPassword.error = "Konfirmasi password tidak boleh kosong"
            isValid = false
        } else if (password != confirmPassword) {
            binding.etConfirmPassword.error = "Password tidak cocok"
            isValid = false
        }

        if (!isValid) return

        // Simpan ke SharedPreferences
        val sharedPref = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
        with(sharedPref.edit()) {
            putString("name", name)
            putString("dob", dob)
            putString("gender", gender)
            putString("religion", religion)
            putString("username", username)
            putString("password", password)
            apply()
        }

        Toast.makeText(this, "Registrasi Berhasil!", Toast.LENGTH_LONG).show()
        finish()
    }
}
