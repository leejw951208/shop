package com.example.shop.domain.product.controller

import com.example.shop.domain.product.dto.ProductDto
import com.example.shop.domain.product.entity.Product
import com.example.shop.domain.product.service.ProductService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductController(
    private val productService: ProductService
) {
    @GetMapping("/api/product/{parentCategoryId}")
    fun findProductsByParentCategoryId(@PathVariable("parentCategoryId") parentCategoryId: Long): ResponseEntity<MutableList<ProductDto>> {
        return ResponseEntity.ok(productService.findProductsByParentCategoryId(parentCategoryId))
    }
    @GetMapping("/api/product/{parentCategoryId}/{categoryId}")
    fun findProductsByCategoryId(@PathVariable("categoryId") categoryId: Long): ResponseEntity<List<ProductDto>> {
        return ResponseEntity.ok(productService.findProductsByCategoryId(categoryId))
    }
}