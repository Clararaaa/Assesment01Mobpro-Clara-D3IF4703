package com.clara0007.yummyfood.screen

import androidx.lifecycle.ViewModel
import com.clara0007.yummyfood.R
import com.clara0007.yummyfood.model.Daftar_Makanan

class MainViewDaftarMakanan : ViewModel (){

    val data = listOf(
        Daftar_Makanan(
            1,
            R.drawable.carbonara,
            "Spaghetti Carbonara",
            "Spaghetti yang dimasak dengan saus telur, keju dan daging.",
            30000
        ),
        Daftar_Makanan(
            2,
            R.drawable.bolognese,
            "Spaghetti Bolognese",
            "Spaghetti yang di masak dengan pasta daging sapi yang di giling dengan" +
                    "potongan wortel kecil dan sosis.",
            28000
        ),
        Daftar_Makanan(
            3,
            R.drawable.Aglio_Oglio,
            "Spaghetti Aglio Oglio",
            "spaghetti dengan bawang putih dan minyak.",
            25000
        ),
        Daftar_Makanan(
            4,
            R.drawable.alfredo,
            "Spaghetti Alfredo",
            "Spaghetti yang dicampur dengan mentega dan keju Parmesan.",
            28000
        ),
        Daftar_Makanan(
            5,
            R.drawable.cappucino,
            "Cappucino",
            "Cappucino hangat",
            15000
        ),
        Daftar_Makanan(
            6,
            R.drawable.blackcurrent,
            "Blackcurrent Squash",
            "Minuman segar blackcurrent dengan soda",
            17000
        ),
        Daftar_Makanan(
            7,
            R.drawable.jus_strawberry,
            "Jus Strawberry",
            "Jus Strawberry dengan susu",
            17000
        )
    )
}