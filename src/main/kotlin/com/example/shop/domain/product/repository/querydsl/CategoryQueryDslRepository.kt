package com.example.shop.domain.product.repository.querydsl

import com.example.shop.domain.product.entity.Category

interface CategoryQueryDslRepository {

    fun findChildCategories(categoryId: Long): MutableList<Category>
}