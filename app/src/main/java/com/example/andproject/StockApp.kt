package com.example.andproject

import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun StockApp() {
    val nav = rememberNavController()
    val goBack: () -> Unit = { nav.popBackStack() }

    NavHost(navController = nav, startDestination = "home") {
        composable("home") {
            StockPage(title = "Qoymaapp") {
                Text("Inventory manager")

                Button(onClick = { nav.navigate("inventory") }) {
                    Text("View inventory")
                }

                OutlinedButton(onClick = { nav.navigate("add") }) {
                    Text("Add product")
                }
            }
        }

        composable("inventory") {
            StockPage(title = "Inventory", onBack = goBack) {
                Text("Your inventory is empty.")
            }
        }

        composable("add") {
            StockPage(title = "Add product", onBack = goBack) {
                Text("Product name and starting quantity")
            }
        }
    }
}