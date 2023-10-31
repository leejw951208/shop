package com.example.shop.domain.product.service

import com.example.shop.domain.product.dto.ProductsDto
import com.example.shop.domain.product.repository.ProductRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ProductService(
    private val productRepository: ProductRepository,
    private val categoryService: CategoryService
) {
    @Transactional(readOnly = true)
    fun findProducts(parentCategoryId: Long): List<ProductsDto> {
        val findChildCategories = categoryService.findChildCategories(parentCategoryId)
        val categoryIds = ArrayList<Long>()
        return productRepository.findProducts(findChildCategories.mapTo(categoryIds) { findSubCategory -> findSubCategory.categoryId })
    }
}