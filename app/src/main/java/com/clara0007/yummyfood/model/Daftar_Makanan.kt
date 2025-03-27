package com.clara0007.yummyfood.model

data class Daftar_Makanan(
    val id: Long,
    val image: Int,
    val nama_makanan: String,
    val deskripsi_makanan: String,
    val harga: Int
)
