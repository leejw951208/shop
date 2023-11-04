package com.example.shop.domain.product.service

import com.example.shop.domain.product.dto.CategoryDto
import com.example.shop.domain.product.repository.CategoryRepository
import org.springframework.stereotype.Service

@Service
class CategoryService(
    private val categoryRepository: CategoryRepository
) {
    fun findCategories(): MutableList<CategoryDto> {
        return categoryRepository.findCategoriesMadeByQueryDsl()
    }
}