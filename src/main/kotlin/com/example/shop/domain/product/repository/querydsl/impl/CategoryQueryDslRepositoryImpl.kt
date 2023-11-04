package com.example.shop.domain.product.repository.querydsl.impl

import com.example.shop.domain.product.dto.CategoryDto
import com.example.shop.domain.product.entity.QCategory.category
import com.example.shop.domain.product.repository.querydsl.CategoryQueryDslRepository
import com.querydsl.core.types.Projections
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class CategoryQueryDslRepositoryImpl(
    private val queryFactory: JPAQueryFactory
) : CategoryQueryDslRepository {
    override fun findCategoriesMadeByQueryDsl(): MutableList<CategoryDto> {
        return queryFactory
            .select(
                Projections.constructor(
                    CategoryDto::class.java,
                    category.categoryId.`as`("categoryId"),
                    category.categoryName.`as`("categoryName"),
                    category.parentCategory.categoryId.`as`("parentCategoryId"),
                    category.parentCategory.categoryName.`as`("parentCategoryName")
                )
            )
            .from(category)
            .fetch()
    }
}