package com.example.andproject

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.navArgument

@Composable
fun StockApp(model: InventoryViewModel = viewModel()) {
    val products by model.products.collectAsStateWithLifecycle()
    val nav = rememberNavController()
    val back: () -> Unit = { nav.popBackStack() }

    NavHost(navController = nav, startDestination = "home") {
        composable("home") {
            HomeScreen(
                summary = products.summary(),
                onInventory = { nav.navigate("inventory") },
                onAdd = { nav.navigate("add") }
            )
        }
        composable(
            route = "product/{id}",
            arguments = listOf(navArgument("id") { type = NavType.StringType })
        ) { entry ->
            val id = entry.arguments?.getString("id")
            val selected = products.find { it.id == id }

            if (selected != null) {
                ProductDetails(
                    product = selected,
                    onBack = back,
                    onSell = model::sell,
                    onRestock = model::restock
                )
            }
        }

        composable("inventory") {
            InventoryScreen(
                products = products,
                onBack = back,
                onOpen = { id -> nav.navigate("product/$id") }
            )
        }

        composable("add") {
            AddProductScreen(
                onBack = back,
                onSave = { name, quantity ->
                    if (model.add(name, quantity)) {
                        nav.navigate("inventory") {
                            popUpTo("home")
                            launchSingleTop = true
                        }
                    }
                }
            )
        }
    }
}