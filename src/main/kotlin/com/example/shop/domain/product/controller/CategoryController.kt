package com.example.shop.domain.product.controller

import com.example.shop.domain.product.dto.CategoryDto
import com.example.shop.domain.product.service.CategoryService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CategoryController(
    private val categoryService: CategoryService
) {
    @GetMapping("/api/categories")
    fun findCategories(): ResponseEntity<MutableList<CategoryDto>> {
        return ResponseEntity.ok(categoryService.findCategories())
    }
}