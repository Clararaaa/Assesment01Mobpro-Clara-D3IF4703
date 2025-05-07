package com.clara0007.yummyfood.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.clara0007.yummyfood.database.AppDatabase
import com.clara0007.yummyfood.database.entity.ItemKeranjang
import com.clara0007.yummyfood.model.Daftar_Makanan
import kotlinx.coroutines.launch

class ViewDaftarMakanan(application: Application) : AndroidViewModel(application) {
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
}