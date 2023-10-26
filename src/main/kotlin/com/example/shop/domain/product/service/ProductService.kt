package com.example.shop.domain.product.service

import com.example.shop.domain.product.dto.ProductsDto
import com.example.shop.domain.product.repository.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductService(
    private val productRepository: ProductRepository
) {
    fun findProducts() {}
}