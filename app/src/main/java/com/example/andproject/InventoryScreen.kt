package com.example.andproject

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ProductRow(product: Product, onOpen: (String) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onOpen(product.id) }
    ) {
        Column(Modifier.padding(16.dp)) {
            Text(product.name, style = MaterialTheme.typography.titleMedium)
            Text("Units: ${product.quantity}")
        }
    }
}

@Composable
fun InventoryScreen(
    products: List<Product>,
    onBack: () -> Unit,
    onOpen: (String) -> Unit
) {
    StockPage("Inventory", onBack) {
        LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            items(products, key = { it.id }) { product ->
                ProductRow(product, onOpen)
            }
        }
    }
}