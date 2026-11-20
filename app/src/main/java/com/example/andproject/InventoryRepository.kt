package com.example.andproject

import java.util.UUID
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class InventoryRepository {
    private val items = MutableStateFlow<List<Product>>(emptyList())
    val products = items.asStateFlow()

    fun add(name: String, quantity: Int): Boolean {
        if (name.isBlank() || quantity < 0) return false

        val product = Product(
            id = UUID.randomUUID().toString(),
            name = name.trim(),
            quantity = quantity
        )

        items.update { current -> current + product }
        return true
    }
}