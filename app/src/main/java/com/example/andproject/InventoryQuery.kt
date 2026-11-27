package com.example.andproject

fun List<Product>.searchByName(query: String): List<Product> {
    val term = query.trim()

    if (term.isEmpty()) {
        return this
    }

    return filter { product ->
        product.name.contains(term, ignoreCase = true)
    }
}