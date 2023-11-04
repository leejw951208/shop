package com.example.shop.domain.product.repository.querydsl.impl

import com.example.shop.domain.product.dto.ProductDto
import com.example.shop.domain.product.entity.QCategory
import com.example.shop.domain.product.entity.QCategory.category
import com.example.shop.domain.product.entity.QProduct
import com.example.shop.domain.product.entity.QProduct.product
import com.example.shop.domain.product.repository.querydsl.ProductQueryDslRepository
import com.querydsl.core.types.Projections
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class ProductQueryDslRepositoryImpl(
    private val queryFactory: JPAQueryFactory
) : ProductQueryDslRepository {
    override fun findProductsByParentCategoryIdMadeByQueryDsl(parentCategoryId: Long): MutableList<ProductDto> {
        return queryFactory
            .select(
                Projections.constructor(
                    ProductDto::class.java,
                    product.productId.`as`("productId"),
                    product.productName.`as`("productName"),
                    product.price.`as`("price"),
                    product.category.categoryId.`as`("categoryId"),
                    product.category.categoryName.`as`("categoryName")
                )
            )
            .from(product)
            .where(product.category.parentCategory.categoryId.eq(parentCategoryId))
            .fetch()
    }

    override fun findProductsByCategoryIdMadeByQueryDsl(categoryId: Long): MutableList<ProductDto> {
        return queryFactory
            .select(
                Projections.constructor(
                    ProductDto::class.java,
                    product.productId.`as`("productId"),
                    product.productName.`as`("productName"),
                    product.price.`as`("price"),
                    product.category.categoryId.`as`("categoryId"),
                    product.category.categoryName.`as`("categoryName")
                )
            )
            .from(product)
            .where(product.category.categoryId.eq(categoryId))
            .fetch()
    }
}