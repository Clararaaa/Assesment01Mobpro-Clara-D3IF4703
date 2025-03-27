package com.clara0007.yummyfood

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.clara0007.yummyfood.screen.MainScreen
import com.clara0007.yummyfood.ui.theme.YummyFoodTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            YummyFoodTheme {
                    MainScreen()
                }
            }
        }
    }
