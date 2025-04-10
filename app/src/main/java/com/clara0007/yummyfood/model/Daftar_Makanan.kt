package com.clara0007.yummyfood.model

import androidx.annotation.StringRes

data class Daftar_Makanan(
    val id: Long,
    val image: Int,
    @StringRes val nama_makanan: Int,
    @StringRes val deskripsi_makanan: Int,
    val harga: Int
)
