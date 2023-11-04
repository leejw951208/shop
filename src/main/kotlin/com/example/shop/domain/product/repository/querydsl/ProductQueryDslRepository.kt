package com.example.shop.domain.product.repository.querydsl

import com.example.shop.domain.product.dto.ProductDto
import org.springframework.stereotype.Repository

@Repository
interface ProductQueryDslRepository {
    fun findProductsByParentCategoryIdMadeByQueryDsl(parentCategoryId: Long): MutableList<ProductDto>
    fun findProductsByCategoryIdMadeByQueryDsl(categoryId: Long): MutableList<ProductDto>
}