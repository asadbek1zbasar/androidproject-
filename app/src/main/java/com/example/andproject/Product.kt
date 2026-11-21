package com.example.andproject

data class Product(
    val id: String,
    val name: String,
    val quantity: Int
) {
    init {
        require(id.isNotBlank())
        require(name.isNotBlank())
        require(quantity >= 0)
    }
}
const val LOW_STOCK_LIMIT = 3

val Product.isLowStock: Boolean
    get() = quantity <= LOW_STOCK_LIMIT

val Product.stockLabel: String
    get() = when {
        quantity == 0 -> "Out of stock"
        isLowStock -> "Low stock"
        else -> "In stock"
    }