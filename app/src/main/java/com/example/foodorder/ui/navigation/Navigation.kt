package com.example.foodorder.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.foodorder.ui.detail.FoodDetail
import com.example.foodorder.ui.home.Feed


const val DetailRoute = "DetailScreen"
enum class Tabs(
    val title: String,
    val icon: ImageVector,
    val route: String
) {
    Feed("Home", Icons.Outlined.Home, "home/feed"),
    Cart("Cart", Icons.Outlined.ShoppingCart, "home/cart"),
}

@Composable
fun FoodOrderNavigationHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(Tabs.Feed.route) {
            Feed(onFoodClick = { navController.navigate("$DetailRoute/$it")})
        }
        composable(
            route = "$DetailRoute/{id}",
            arguments = listOf(navArgument("id") {}),
        ) {
            val id = it.arguments?.getString("id") ?: "1"
            FoodDetail(foodId = id.toLong()) {
                navController.navigateUp()
            }
        }
    }
}