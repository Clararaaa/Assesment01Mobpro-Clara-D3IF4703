package com.clara0007.yummyfood.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.clara0007.yummyfood.database.AppDatabase
import com.clara0007.yummyfood.database.entity.ItemKeranjang
import com.clara0007.yummyfood.model.Daftar_Makanan
import com.clara0007.yummyfood.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ViewDaftarMakanan(application: Application) : AndroidViewModel(application) {

    val data = listOf(
        Daftar_Makanan(1, R.drawable.carbonara, R.string.carbonara, R.string.desc_carbonara, 30000),
        Daftar_Makanan(2, R.drawable.bolognese, R.string.bolognese, R.string.desc_bolognese, 28000),
        Daftar_Makanan(3, R.drawable.agliooglio, R.string.aglio, R.string.desc_aglio, 25000),
        Daftar_Makanan(4, R.drawable.alfredo, R.string.alfredo, R.string.desc_alfredo, 28000),
        Daftar_Makanan(5, R.drawable.cappucino, R.string.cappucino, R.string.desc_cappucino, 15000),
        Daftar_Makanan(6, R.drawable.blackcurrent, R.string.blackcurrent, R.string.desc_blackcurrent, 17000),
        Daftar_Makanan(7, R.drawable.jus_strawberry, R.string.strawberry, R.string.desc_strawberry, 17000)
    )

    private val db = Room.databaseBuilder(
        application,
        AppDatabase::class.java,
        "yummyfood-db"
    ).build()

    private val keranjangDao = db.keranjangDao()

    fun addToCart(item: Daftar_Makanan) {
        viewModelScope.launch {
            val itemKeranjang = ItemKeranjang(
                nama = item.nama_makanan.toString(),
                harga = item.harga,
                jumlah = 1, // default awal 1
                image = item.image
            )
            keranjangDao.insert(itemKeranjang)
        }
    }

    fun getAllItems(onResult: (List<ItemKeranjang>) -> Unit) {
        viewModelScope.launch {
            val items = keranjangDao.getAll()
            onResult(items)
        }
    }

    private val _totalItem = MutableStateFlow(0)
    val totalItem: StateFlow<Int> = _totalItem

    private val _totalHarga = MutableStateFlow(0)
    val totalHarga: StateFlow<Int> = _totalHarga

    fun updateTotal(item: Int, harga: Int) {
        _totalItem.value = item
        _totalHarga.value = harga
    }
    fun tambahItem(harga: Int) {
        _totalItem.value++
        _totalHarga.value += harga
    }

    fun kurangiItem(harga: Int) {
        if (_totalItem.value > 0) _totalItem.value--
        if (_totalHarga.value >= harga) _totalHarga.value -= harga
    }

}