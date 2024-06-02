package com.example.foodorder.model

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.vector.ImageVector

class Filter(
    val name: String,
    enabled: Boolean = false,
    val icon: ImageVector? = null
) {
    val enabled = mutableStateOf(enabled)
}

val filters = listOf(
    Filter(name = "Organic"),
    Filter(name = "Gluten-free"),
    Filter(name = "Daily-free"),
    Filter(name = "Sweet"),
    Filter(name = "Savory"),
)