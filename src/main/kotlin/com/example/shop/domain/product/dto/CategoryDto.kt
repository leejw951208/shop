package com.example.shop.domain.product.dto

data class CategoryDto(
    val categoryId: Long,
    val categoryName: String,
    val parentCategoryId: Long,
    val parentCategoryName: String
)
