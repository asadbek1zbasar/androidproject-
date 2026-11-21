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
    var attempted by rememberSaveable { mutableStateOf(false) }
    val parsedQuantity = quantity.toIntOrNull()

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

            if (attempted && name.isBlank()) {
                Text("Enter a product name.", color = MaterialTheme.colorScheme.error)
            }

            if (attempted && (parsedQuantity == null || parsedQuantity < 0)) {
                Text(
                    "Enter a whole quantity of zero or more.",
                    color = MaterialTheme.colorScheme.error
                )
            }

            Button(onClick = {
                attempted = true
                if (name.isNotBlank() && parsedQuantity != null && parsedQuantity >= 0) {
                    onSave(name.trim(), parsedQuantity)
                }
            }) {
                Text("Save")
            }
        }
    }
}