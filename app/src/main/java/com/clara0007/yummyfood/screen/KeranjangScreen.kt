package com.clara0007.yummyfood.screen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.clara0007.yummyfood.database.entity.ItemKeranjang
import com.clara0007.yummyfood.viewmodel.ViewDaftarMakanan

@Composable
fun KeranjangScreen(viewModel: ViewDaftarMakanan) {
    var itemList by remember { mutableStateOf<List<ItemKeranjang>>(emptyList()) }

    LaunchedEffect(Unit) {
        viewModel.getAllItems {
            itemList = it
        }
    }

    LazyColumn {
        items(itemList) { item ->
            ItemKeranjangColom(item)
        }
    }
}