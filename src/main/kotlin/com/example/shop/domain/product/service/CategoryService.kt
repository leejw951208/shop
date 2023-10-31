package com.example.shop.domain.product.service

import com.example.shop.domain.product.entity.Category
import com.example.shop.domain.product.repository.CategoryRepository
import org.springframework.stereotype.Service

@Service
class CategoryService(
    private val categoryRepository: CategoryRepository
) {
    fun findChildCategories(categoryId: Long): MutableList<Category> {
        return categoryRepository.findChildCategories(categoryId)
    }
}