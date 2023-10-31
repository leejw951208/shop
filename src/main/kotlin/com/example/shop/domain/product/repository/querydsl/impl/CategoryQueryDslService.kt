package com.example.shop.domain.product.repository.querydsl.impl

import com.example.shop.domain.product.entity.Category
import com.example.shop.domain.product.entity.QCategory
import com.example.shop.domain.product.entity.QCategory.category
import com.example.shop.domain.product.repository.querydsl.CategoryQueryDslRepository
import com.querydsl.core.types.Projections
import com.querydsl.jpa.impl.JPAQueryFactory

import org.springframework.stereotype.Service

@Service
class CategoryQueryDslService(
    private val queryFactory: JPAQueryFactory
) : CategoryQueryDslRepository {
    override fun findChildCategories(categoryId: Long): MutableList<Category> {
        return queryFactory
            .selectFrom(category)
            .where(category.parentCategory.categoryId.eq(categoryId))
            .fetch();
    }
}