package com.example.shop.domain.product.repository

import com.example.shop.domain.product.entity.Category
import com.example.shop.domain.product.repository.querydsl.CategoryQueryDslRepository
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CategoryRepository : JpaRepository<Category, Long>, CategoryQueryDslRepository{
}