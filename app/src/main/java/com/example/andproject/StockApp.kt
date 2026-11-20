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
            StockPage("Qoymaapp") {
                Button(onClick = { nav.navigate("inventory") }) {
                    Text("View inventory")
                }
                OutlinedButton(onClick = { nav.navigate("add") }) {
                    Text("Add product")
                }
            }
        }

        composable("inventory") {
            StockPage("Inventory", back) {
                Text("Your products")
            }
        }

        composable("add") {
            StockPage("Add product", back) {
                Text("Product form")
            }
        }
    }
}