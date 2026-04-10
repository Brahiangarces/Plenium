package com.plenium.ecommerce

import java.io.Serializable

data class Product(
    val name: String,
    val price: Int,
    val description: String,
    val imageKey: String,
    val stock: Int
) : Serializable
