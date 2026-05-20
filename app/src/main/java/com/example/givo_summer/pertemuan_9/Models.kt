package com.example.givo_summer.pertemuan_9

data class ProfilDesa(
    val profilId: Int,
    val namaDesa: String,
    val kecamatan: String,
    val kabupaten: String,
    val provinsi: String,
    val alamatKantor: String,
    val email: String,
    val telepon: String,
    val visi: String,
    val misi: String,
    val logoUrl: String
)

data class KategoriBerita(
    val kategoriId: Int,
    val nama: String,
    val slug: String,
    val deskripsi: String
)

data class Berita(
    val beritaId: Int,
    val kategoriId: Int,
    val judul: String,
    val slug: String,
    val isiHtml: String,
    val penulis: String,
    val status: String,
    val terbitAt: String,
    val coverUrl: String
)

data class Agenda(
    val agendaId: Int,
    val judul: String,
    val lokasi: String,
    val tanggalMulai: String,
    val tanggalSelesai: String,
    val penyelenggara: String,
    val deskripsi: String,
    val posterUrl: String
)

data class Galeri(
    val galeriId: Int,
    val judul: String,
    val deskripsi: String,
    val fotoUrl: String
)
