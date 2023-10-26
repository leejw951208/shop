package com.example.shop.domain.product.dto

data class ProductsDto(
    val id: Long,
    val category: CategoryDto,
    val productName: String,
    val price: Int
)
