package com.example.shop.domain.product.repository.querydsl

import com.example.shop.domain.product.dto.ProductsDto
import org.springframework.stereotype.Repository

interface ProductQueryDslRepository {
    fun findProducts(categoryIds: List<Long>): MutableList<ProductsDto>
}