package com.example.andproject

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun AddProductScreen(
    onBack: () -> Unit,
    onSave: (String, Int) -> Unit
) {
    var name by rememberSaveable { mutableStateOf("") }
    var quantity by rememberSaveable { mutableStateOf("") }

    StockPage("Add product", onBack) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .imePadding(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Product name") },
                singleLine = true
            )

            OutlinedTextField(
                value = quantity,
                onValueChange = { quantity = it },
                label = { Text("Starting quantity") },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
                singleLine = true
            )

            Button(onClick = {
                quantity.toIntOrNull()?.let { onSave(name, it) }
            }) {
                Text("Save")
            }
        }
    }
}