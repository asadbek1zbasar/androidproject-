package com.example.andproject

import androidx.compose.material3.*
import androidx.compose.runtime.Composable

@Composable
fun ProductDetails(
    product: Product,
    onBack: () -> Unit,
    onSell: (String) -> Unit,
    onRestock: (String) -> Unit
) {
    StockPage("Product details", onBack) {
        Text(product.name, style = MaterialTheme.typography.titleLarge)
        Text("Units: ${product.quantity}")

        Button(
            enabled = product.quantity > 0,
            onClick = { onSell(product.id) }
        ) {
            Text("Record sale")
        }

        OutlinedButton(
            enabled = product.quantity < Int.MAX_VALUE,
            onClick = { onRestock(product.id) }
        ) {
            Text("Restock")
        }
    }
}