package com.example.givo_summer.pertemuan_9

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.givo_summer.databinding.FragmentTabCBinding

class TabCFragment : Fragment() {

    private var _binding: FragmentTabCBinding? = null
    private val binding get() = _binding!!

    private val productList = listOf(
        ProductModel("Pupuk Organik Cair", "Rp 45.000", "https://picsum.photos/seed/pupuk1/400/300"),
        ProductModel("Benih Padi Unggul", "Rp 120.000", "https://picsum.photos/seed/padi1/400/300"),
        ProductModel("Cangkul Baja", "Rp 85.000", "https://picsum.photos/seed/cangkul1/400/300"),
        ProductModel("Bibit Durian Bawor", "Rp 75.000", "https://picsum.photos/seed/durian1/400/300"),
        ProductModel("Sprayer Pertanian", "Rp 350.000", "https://picsum.photos/seed/sprayer1/400/300"),
        ProductModel("Caping Petani", "Rp 25.000", "https://picsum.photos/seed/caping1/400/300"),
        ProductModel("Sepatu Boot Karet", "Rp 65.000", "https://picsum.photos/seed/boot1/400/300"),
        ProductModel("Gunting Stek", "Rp 40.000", "https://picsum.photos/seed/gunting1/400/300"),
        ProductModel("Traktor Tangan", "Rp 15.500.000", "https://picsum.photos/seed/traktor1/400/300"),
        ProductModel("Polibag 100pcs", "Rp 35.000", "https://picsum.photos/seed/polybag1/400/300"),
        
        ProductModel("Sabun Sereh Desa", "Rp 15.000", "https://picsum.photos/seed/soap1/400/300"),
        ProductModel("Minyak Kelapa Murni", "Rp 45.000", "https://picsum.photos/seed/vco1/400/300"),
        ProductModel("Teh Kelor", "Rp 25.000", "https://picsum.photos/seed/tea1/400/300"),
        ProductModel("Kopi Robusta Desa", "Rp 35.000", "https://picsum.photos/seed/coffee1/400/300"),
        ProductModel("Gula Semut Aren", "Rp 30.000", "https://picsum.photos/seed/sugar1/400/300"),
        ProductModel("Keripik Tempe", "Rp 12.000", "https://picsum.photos/seed/tempe1/400/300"),
        ProductModel("Madu Hutan Asli", "Rp 150.000", "https://picsum.photos/seed/honey1/400/300"),
        ProductModel("Telur Ayam Kampung", "Rp 3.000/butir", "https://picsum.photos/seed/egg1/400/300"),
        ProductModel("Ikan Asin Tenggiri", "Rp 40.000", "https://picsum.photos/seed/fish1/400/300"),
        ProductModel("Beras Merah Organik", "Rp 25.000", "https://picsum.photos/seed/rice1/400/300"),

        ProductModel("Tas Anyaman Pandan", "Rp 75.000", "https://picsum.photos/seed/bag1/400/300"),
        ProductModel("Dompet Lidi", "Rp 35.000", "https://picsum.photos/seed/wallet1/400/300"),
        ProductModel("Tikar Mendong", "Rp 120.000", "https://picsum.photos/seed/mat1/400/300"),
        ProductModel("Topi Bambu", "Rp 45.000", "https://picsum.photos/seed/hat1/400/300"),
        ProductModel("Sandal Kayu Bakiak", "Rp 25.000", "https://picsum.photos/seed/sandal1/400/300"),
        ProductModel("Pajangan Bambu", "Rp 55.000", "https://picsum.photos/seed/decor1/400/300"),
        ProductModel("Asbak Kayu Jati", "Rp 35.000", "https://picsum.photos/seed/wood1/400/300"),
        ProductModel("Cobek Batu Asli", "Rp 85.000", "https://picsum.photos/seed/stone1/400/300"),
        ProductModel("Gantungan Kunci Kayu", "Rp 5.000", "https://picsum.photos/seed/key1/400/300"),
        ProductModel("Kaos Bina Desa", "Rp 85.000", "https://picsum.photos/seed/tshirt1/400/300"),

        ProductModel("Bibit Alpukat Miki", "Rp 65.000", "https://picsum.photos/seed/avocado1/400/300"),
        ProductModel("Bibit Jambu Kristal", "Rp 45.000", "https://picsum.photos/seed/guava1/400/300"),
        ProductModel("Bibit Kelengkeng", "Rp 55.000", "https://picsum.photos/seed/longan1/400/300"),
        ProductModel("Pestisida Nabati", "Rp 35.000", "https://picsum.photos/seed/pest1/400/300"),
        ProductModel("Media Tanam Kompos", "Rp 15.000", "https://picsum.photos/seed/soil1/400/300"),
        ProductModel("Pot Tanaman Cantik", "Rp 20.000", "https://picsum.photos/seed/pot1/400/300"),
        ProductModel("Sekop Taman Mini", "Rp 15.000", "https://picsum.photos/seed/shovel1/400/300"),
        ProductModel("Selang Air 10m", "Rp 75.000", "https://picsum.photos/seed/hose1/400/300"),
        ProductModel("Waring Jaring 1m", "Rp 10.000", "https://picsum.photos/seed/net1/400/300"),
        ProductModel("Gembor Air 5L", "Rp 35.000", "https://picsum.photos/seed/water1/400/300"),

        ProductModel("Kandang Ayam Portable", "Rp 450.000", "https://picsum.photos/seed/cage1/400/300"),
        ProductModel("Tempat Makan Ayam", "Rp 15.000", "https://picsum.photos/seed/feeder1/400/300"),
        ProductModel("Pakan Ternak Konsentrat", "Rp 180.000", "https://picsum.photos/seed/feed1/400/300"),
        ProductModel("Vitamin Ternak", "Rp 25.000", "https://picsum.photos/seed/vit1/400/300"),
        ProductModel("Jaring Pagar Kebun", "Rp 95.000", "https://picsum.photos/seed/fence1/400/300"),
        ProductModel("Parang Tebas", "Rp 65.000", "https://picsum.photos/seed/knife1/400/300"),
        ProductModel("Sabit Rumput", "Rp 45.000", "https://picsum.photos/seed/sickle1/400/300"),
        ProductModel("Tali Rafia Besar", "Rp 15.000", "https://picsum.photos/seed/rope1/400/300"),
        ProductModel("Terpal Kolam Ikan", "Rp 150.000", "https://picsum.photos/seed/tarp1/400/300"),
        ProductModel("Pompa Air Celup", "Rp 250.000", "https://picsum.photos/seed/pump1/400/300")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTabCBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = ProductAdapter(productList) { selectedItem ->
            Toast.makeText(requireContext(), "Produk Bina Desa: ${selectedItem.name}", Toast.LENGTH_SHORT).show()
        }

        binding.rvProducts.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            this.adapter = adapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
