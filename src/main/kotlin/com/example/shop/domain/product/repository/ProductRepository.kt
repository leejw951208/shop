package com.example.shop.domain.product.repository

import com.example.shop.domain.product.entity.Product
import com.example.shop.domain.product.repository.querydsl.ProductQueryDslRepository
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository : JpaRepository<Product, Long>, ProductQueryDslRepository {
}