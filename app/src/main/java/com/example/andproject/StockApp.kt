package com.example.andproject

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun StockApp(model: InventoryViewModel = viewModel()) {
    val products by model.products.collectAsStateWithLifecycle()
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
                products = products,
                onBack = back,
                onOpen = {}
            )
        }

        composable("add") {
            AddProductScreen(onBack = back, onSave = { _, _ -> })
        }
    }
}