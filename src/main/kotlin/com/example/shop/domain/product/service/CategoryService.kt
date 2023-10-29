package com.example.shop.domain.product.service

import com.example.shop.domain.product.dto.CategorySaveDto
import com.example.shop.domain.product.entity.Category
import com.example.shop.domain.product.repository.CategoryRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CategoryService(
    private val categoryRepository: CategoryRepository
) {
    @Transactional
    fun saveCategory(categorySaveDto: CategorySaveDto) {
        val findCategory = categorySaveDto.parentCategoryId?.let { categoryRepository.findByIdOrNull(it) }
        categoryRepository.save(Category(findCategory, categorySaveDto.categoryName, null, null))
    }
}