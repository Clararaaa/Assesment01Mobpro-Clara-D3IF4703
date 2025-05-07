package com.clara0007.yummyfood.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.clara0007.yummyfood.database.entity.ItemKeranjang

@Dao
interface KeranjangDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(itemKeranjang: ItemKeranjang)

    @Query("SELECT * FROM cart_item")
    suspend fun getAll(): List<ItemKeranjang>

    @Delete
    suspend fun delete(itemKeranjang: ItemKeranjang)

    @Query("DELETE FROM cart_item")
    suspend fun clearCart()
}
