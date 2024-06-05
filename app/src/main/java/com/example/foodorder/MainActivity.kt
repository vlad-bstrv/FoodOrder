package com.example.foodorder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.foodorder.ui.detail.FoodDetail
import com.example.foodorder.ui.home.Feed
import com.example.foodorder.ui.navigation.FoodOrderNavigationHost
import com.example.foodorder.ui.navigation.Tabs
import com.example.foodorder.ui.theme.FoodOrderTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FoodOrderTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FoodOrderApp()
                }
            }
        }
    }

    @Composable
    fun FoodOrderApp() {
        val navController = rememberNavController()
        Scaffold {
            FoodOrderNavigationHost(
                startDestination = Tabs.Feed.route,
                modifier = Modifier.padding(paddingValues = it),
                navController = navController
            )
        }
    }
}
