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