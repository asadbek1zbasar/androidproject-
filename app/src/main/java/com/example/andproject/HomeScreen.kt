package com.example.andproject

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HomeScreen(onInventory: () -> Unit, onAdd: () -> Unit) {
    StockPage("Qoymaapp") {
        Text("Inventory manager")
        Button(onClick = onInventory) { Text("View inventory") }
        OutlinedButton(onClick = onAdd) { Text("Add product") }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomePreview() {
    MaterialTheme {
        HomeScreen(onInventory = {}, onAdd = {})
    }
}