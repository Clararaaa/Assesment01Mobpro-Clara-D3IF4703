package com.clara0007.yummyfood.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cart_item")
class ItemKeranjang(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val nama: String,
    val harga: Int,
    val jumlah: Int,
    val image: Int
) {
}