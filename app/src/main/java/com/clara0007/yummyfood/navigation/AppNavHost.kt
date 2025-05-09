package com.clara0007.yummyfood.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.clara0007.yummyfood.screen.CoverScreen
import com.clara0007.yummyfood.screen.KeranjangScreen
import com.clara0007.yummyfood.screen.MainScreen
import com.clara0007.yummyfood.viewmodel.ViewDaftarMakanan
import com.clara0007.yummyfood.model.Screen


@Composable
fun AppNavHost(navController: NavHostController) {

    val viewModel: ViewDaftarMakanan = viewModel()

    NavHost(
        navController = navController,
        startDestination = "cover"
    ) {
        composable("cover") {
            CoverScreen(onStartClick = {
                navController.navigate("main")
            })
        }
        composable(Screen.Home.route) {
            MainScreen(
                viewModel = viewModel,
                onKeranjangClick = {
                    navController.navigate(Screen.Keranjang.route)
                },
                onNavigateBack = { navController.popBackStack() }
            )
        }
        composable(Screen.Keranjang.route) {
            KeranjangScreen(viewModel = viewModel)
        }
    }
}