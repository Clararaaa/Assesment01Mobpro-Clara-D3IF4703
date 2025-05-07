package com.clara0007.yummyfood.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.clara0007.yummyfood.database.dao.KeranjangDao
import com.clara0007.yummyfood.database.entity.ItemKeranjang

@Database(entities = [ItemKeranjang ::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun keranjangDao(): KeranjangDao
}
