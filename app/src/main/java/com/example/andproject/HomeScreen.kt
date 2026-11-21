package com.example.andproject

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HomeScreen(
    summary: InventorySummary,
    onInventory: () -> Unit,
    onAdd: () -> Unit
) {
    StockPage("Qoymaapp") {
        Text("Products: ${summary.totalProducts}")
        Text("Low stock: ${summary.lowStockProducts}")
        Button(onClick = onInventory) { Text("View inventory") }
        OutlinedButton(onClick = onAdd) { Text("Add product") }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomePreview() {
    MaterialTheme {
        HomeScreen(
            summary = InventorySummary(2, 1),
            onInventory = {},
            onAdd = {}
        )
    }
}