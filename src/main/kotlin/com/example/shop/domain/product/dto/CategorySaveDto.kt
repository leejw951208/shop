package com.example.shop.domain.product.dto

import jakarta.validation.constraints.NotBlank

data class CategorySaveDto(
    val parentCategoryId: Long?,

    @field:NotBlank(message = "카테고리명은 필수 입니다.")
    val categoryName: String?
)
