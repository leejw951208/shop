package com.example.shop

import com.example.shop.domain.product.dto.CategorySaveDto
import com.example.shop.domain.product.service.CategoryService
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
class CategoryTests @Autowired constructor(
    private val categoryService: CategoryService
) {
    @Test
    @DisplayName(value = "카테고리 등록 테스트")
    @Transactional
    fun saveCategory() {
        categoryService.saveCategory(CategorySaveDto(null, "상의"))
    }
}