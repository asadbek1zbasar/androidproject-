package com.example.andproject

data class InventorySummary(
    val totalProducts: Int,
    val lowStockProducts: Int
)

fun List<Product>.summary(): InventorySummary {
    return InventorySummary(
        totalProducts = size,
        lowStockProducts = count { it.isLowStock }
    )
}