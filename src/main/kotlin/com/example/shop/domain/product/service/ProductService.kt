package com.example.shop.domain.product.service

import com.example.shop.domain.product.dto.ProductDto
import com.example.shop.domain.product.repository.ProductRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ProductService(
    private val productRepository: ProductRepository
) {
    @Transactional(readOnly = true)
    fun findProductsByParentCategoryId(parentCategoryId: Long): MutableList<ProductDto> {
        return productRepository.findProductsByParentCategoryIdMadeByQueryDsl(parentCategoryId)
    }

    @Transactional(readOnly = true)
    fun findProductsByCategoryId(categoryId: Long): MutableList<ProductDto> {
        return productRepository.findProductsByCategoryIdMadeByQueryDsl(categoryId)
    }
}