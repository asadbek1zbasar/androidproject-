package com.example.andproject

import androidx.compose.material3.*
import androidx.compose.runtime.Composable

@Composable
fun ProductDetails(product: Product, onBack: () -> Unit) {
    StockPage("Product details", onBack) {
        Text(product.name, style = MaterialTheme.typography.titleLarge)
        Text("Units: ${product.quantity}")
    }
}