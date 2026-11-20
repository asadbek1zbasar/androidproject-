package com.example.andproject

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun StockApp() {
    val nav = rememberNavController()
    val back: () -> Unit = { nav.popBackStack() }

    NavHost(navController = nav, startDestination = "home") {
        composable("home") {
            HomeScreen(
                onInventory = { nav.navigate("inventory") },
                onAdd = { nav.navigate("add") }
            )
        }

        composable("inventory") {
            InventoryScreen(
                products = listOf(
                    Product("demo-1", "E88 Drone", 4),
                    Product("demo-2", "Kettle", 2)
                ),
                onBack = back,
                onOpen = {}
            )
        }

        composable("add") {
            AddProductScreen(onBack = back, onSave = { _, _ -> })
        }
    }
}