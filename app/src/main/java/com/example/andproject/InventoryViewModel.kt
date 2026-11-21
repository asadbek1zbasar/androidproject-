package com.example.andproject

import androidx.lifecycle.ViewModel

class InventoryViewModel : ViewModel() {
    private val repository = InventoryRepository()

    val products = repository.products

    fun add(name: String, quantity: Int): Boolean {
        return repository.add(name, quantity)
    }
}