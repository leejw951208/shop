package com.example.shop

import com.example.shop.domain.product.entity.Category
import com.example.shop.domain.product.repository.CategoryRepository
import com.example.shop.domain.product.service.CategoryService
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.Rollback
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
class CategoryTests @Autowired constructor(
    private val categoryRepository: CategoryRepository
) {
    @Test
    @DisplayName(value = "카테고리 더미 데이터 등록 테스트")
    @Transactional
//    @Rollback(false)
    fun init() {
        val top = categoryRepository.save(Category(null, "상의", null, null))
        categoryRepository.save(Category(top, "셔츠", null, null))
        categoryRepository.save(Category(top, "맨투맨", null, null))

        val bottom = categoryRepository.save(Category(null, "하의", null, null))
        categoryRepository.save(Category(bottom, "청바지", null, null))
        categoryRepository.save(Category(bottom, "반바지", null, null))
    }
}