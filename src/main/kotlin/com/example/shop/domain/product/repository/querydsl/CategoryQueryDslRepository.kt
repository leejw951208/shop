package com.example.shop.domain.product.repository.querydsl

import com.example.shop.domain.product.dto.CategoryDto
import com.example.shop.domain.product.entity.Category
import org.springframework.stereotype.Repository

@Repository
interface CategoryQueryDslRepository {

    fun findCategoriesMadeByQueryDsl(): MutableList<CategoryDto>
}