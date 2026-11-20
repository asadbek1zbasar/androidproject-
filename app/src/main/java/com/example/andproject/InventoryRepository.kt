package com.example.andproject

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class InventoryRepository {
    private val items = MutableStateFlow<List<Product>>(emptyList())
    val products = items.asStateFlow()
}