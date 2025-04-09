package com.clara0007.yummyfood.screen

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.clara0007.yummyfood.R
import com.clara0007.yummyfood.model.Daftar_Makanan
import com.clara0007.yummyfood.ui.theme.YummyFoodTheme
import java.text.NumberFormat
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(){
    Scaffold (
        topBar = {
            TopAppBar(
                title = {
                    Text( text = stringResource(id = R.string.app_name))
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                )
            )
        },
        bottomBar = {
            ChechOutBar(
                totalHarga = 23000,
                item = 1,
                onCheckoutClick = {}
            )
        }
    ){ innerPadding ->
        ScreenContent(Modifier.padding(innerPadding))
    }
}

@Composable
fun ScreenContent(modifier: Modifier = Modifier) {
    var searchText by remember { mutableStateOf("") }
    val viewModel: MainViewDaftarMakanan = viewModel()
    val data = viewModel.data

    val filteredData = remember(searchText, data) {
        if (searchText.isBlank()) {
            data
        } else {
            data.sortedByDescending { item ->
                item.nama_makanan.contains(searchText, ignoreCase = true)
            }
        }
    }
    Column(modifier = modifier.padding(12.dp)) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextField(
                value = searchText,
                onValueChange = { searchText = it },
                placeholder = {
                    Text(
                        text = "Cari makanan...",
                        style = MaterialTheme.typography.bodySmall.copy(
                            color = Color.White
                        )
                    )
                },
                textStyle = MaterialTheme.typography.bodySmall.copy(
                    fontSize = 12.sp,
                    color = Color.White
                ),
                modifier = Modifier
                    .weight(1f)
                    .height(45.dp),
                singleLine = true,
                shape = RoundedCornerShape(5.dp)
            )

            Spacer(modifier = Modifier.width(8.dp))

            Button(
                onClick = {},
                modifier = Modifier.height(45.dp),
                shape = RoundedCornerShape(5.dp)
            ) {
                Icon(Icons.Default.Search, contentDescription = "Cari")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(filteredData) {
                ListItem(daftarMakanan = it)
                HorizontalDivider()
            }
        }
    }
}

@Composable
fun ListItem(daftarMakanan: Daftar_Makanan) {
    var quantity by remember { mutableIntStateOf(0) }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        val image = painterResource(id = daftarMakanan.image)

        val hargaFormat =
            NumberFormat.getNumberInstance(Locale("in", "ID")).format(daftarMakanan.harga)

        // Gambar Makanan
        Image(
            painter = image,
            contentDescription = stringResource(
                R.string.gambar_makanan,
                daftarMakanan.nama_makanan
            ),
            modifier = Modifier
                .size(100.dp)
                .padding(end = 12.dp)
        )

        // colom text untuk info makanan
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = daftarMakanan.nama_makanan,
                style = MaterialTheme.typography.titleLarge
            )
            Text(
                text = daftarMakanan.deskripsi_makanan,
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = stringResource(
                    R.string.format_harga, "",
                    hargaFormat
                ),
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = MaterialTheme.colorScheme.error
                )
            )

            Spacer(modifier = Modifier.height(10.dp))

            QuantitySelector(
                quantity = quantity,
                onIncrement = { quantity++ },
                onDecrement = { if (quantity > 0) quantity-- }
            )
        }
    }
}

@Composable
fun QuantitySelector(
    quantity: Int,
    onIncrement: () -> Unit,
    onDecrement: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(
            onClick = onDecrement,
            modifier = Modifier
                .size(width = 24.dp, height = 24.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFB0C4FF)),
            contentPadding = PaddingValues(0.dp),
            shape = RoundedCornerShape(0.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Remove,
                contentDescription = stringResource(R.string.kurang),
                tint = Color.White
            )
        }

        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = quantity.toString(),
            fontSize = 20.sp,
            modifier = Modifier.width(24.dp),
            textAlign = TextAlign.Center,
            color = Color.White
        )

        Spacer(modifier = Modifier.width(8.dp))

        Button(
            onClick = onIncrement,
            modifier = Modifier
                .size(width = 24.dp, height = 24.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFB0C4FF)),
            contentPadding = PaddingValues(0.dp),
            shape = RoundedCornerShape(0.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = stringResource(R.string.tambah),
                tint = Color.White
            )
        }
    }
}

@Composable
fun ChechOutBar(
    totalHarga: Int,
    item: Int,
    onCheckoutClick: () -> Unit
) {
    Surface(
        tonalElevation = 4.dp,
        shadowElevation = 8.dp,
        color = MaterialTheme.colorScheme.surface,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.ShoppingCart,
                    contentDescription = "Keranjang",
                    tint = MaterialTheme.colorScheme.primary
                )
                if (item > 0) {
                    Text(
                        text = "$item",
                        modifier = Modifier.padding(start = 4.dp),
                        fontSize = 14.sp,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Rp${totalHarga}",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = MaterialTheme.colorScheme.primary
                )
            }
            Button(
                onClick = onCheckoutClick,
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(text = "Checkout", color = Color.White)
            }
        }
    }
}

@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun MainScreenPreview(){
    YummyFoodTheme {
        MainScreen()
    }
}