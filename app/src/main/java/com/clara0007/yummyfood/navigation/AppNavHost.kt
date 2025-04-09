package com.clara0007.yummyfood.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.clara0007.yummyfood.screen.CoverScreen
import com.clara0007.yummyfood.screen.MainScreen


@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "cover"
    ) {
        composable("cover") {
            CoverScreen(onStartClick = {
                navController.navigate("main")
            })
        }
        composable("main"){
            MainScreen()
        }
    }
}