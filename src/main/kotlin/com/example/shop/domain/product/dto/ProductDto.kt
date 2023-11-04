package com.example.shop.domain.product.dto

data class ProductDto(
    val productId: Long,
    val productName: String,
    val price: Int,
    val categoryId: Long,
    val categoryName: String
)
