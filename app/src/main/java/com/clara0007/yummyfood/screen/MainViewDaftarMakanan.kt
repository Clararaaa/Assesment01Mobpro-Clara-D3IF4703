package com.clara0007.yummyfood.screen

import androidx.lifecycle.ViewModel
import com.clara0007.yummyfood.R
import com.clara0007.yummyfood.model.Daftar_Makanan

class MainViewDaftarMakanan : ViewModel (){

    val data = listOf(
        Daftar_Makanan(
            1,
            R.drawable.carbonara,
            R.string.carbonara,
            R.string.desc_carbonara,
            30000
        ),
        Daftar_Makanan(
            2,
            R.drawable.bolognese,
            R.string.bolognese,
            R.string.desc_bolognese,
            28000
        ),
        Daftar_Makanan(
            3,
            R.drawable.agliooglio,
            R.string.aglio,
            R.string.desc_aglio,
            25000
        ),
        Daftar_Makanan(
            4,
            R.drawable.alfredo,
            R.string.alfredo,
            R.string.desc_alfredo,
            28000
        ),
        Daftar_Makanan(
            5,
            R.drawable.cappucino,
            R.string.cappucino,
            R.string.desc_cappucino,
            15000
        ),
        Daftar_Makanan(
            6,
            R.drawable.blackcurrent,
            R.string.blackcurrent,
            R.string.desc_blackcurrent,
            17000
        ),
        Daftar_Makanan(
            7,
            R.drawable.jus_strawberry,
            R.string.strawberry,
            R.string.desc_strawberry,
            17000
        )
    )
}