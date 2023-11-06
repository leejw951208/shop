package com.example.shop.domain.product.service

import com.example.shop.domain.product.dto.ProductDto
import com.example.shop.domain.product.repository.ProductRepository
import com.example.shop.logger
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.server.ResponseStatusException

@Service
class ProductService(
    private val productRepository: ProductRepository
) {
    val log = logger()

    @Transactional(readOnly = true)
    fun findProductsByParentCategoryId(parentCategoryId: Long): MutableList<ProductDto> {
        return productRepository.findProductsByParentCategoryIdMadeByQueryDsl(parentCategoryId)
    }

    @Transactional(readOnly = true)
    fun findProductsByCategoryId(categoryId: Long): MutableList<ProductDto> {
        return productRepository.findProductsByCategoryIdMadeByQueryDsl(categoryId)
    }

    @Transactional(readOnly = true)
    fun findProductByProductId(productId: Long): ProductDto? {
        log.info("조회 상품 아이디 = {}", productId)
        return productRepository.findProductByProductIdMadeByQueryDsl(productId)
    }
}