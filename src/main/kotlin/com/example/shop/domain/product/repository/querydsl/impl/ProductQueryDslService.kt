package com.example.shop.domain.product.repository.querydsl.impl

import com.example.shop.domain.product.dto.ProductsDto
import com.example.shop.domain.product.entity.QProduct
import com.example.shop.domain.product.entity.QProduct.product
import com.example.shop.domain.product.repository.querydsl.ProductQueryDslRepository
import com.querydsl.core.types.Projections
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Service

@Service
class ProductQueryDslService(
    private val queryFactory: JPAQueryFactory
) : ProductQueryDslRepository {
    override fun findProducts(categoryIds: List<Long>): MutableList<ProductsDto> {
        return queryFactory
            .select(
                Projections.fields(
                    ProductsDto::class.java,
                    product.productId.`as`("productId"),
                    product.productName.`as`("productName"),
                    product.price.`as`("price"),
                    product.category.categoryId.`as`("categoryId"),
                    product.category.categoryName.`as`("categoryName")
                )
            )
            .from(product)
            .where(product.category.categoryId.`in`(categoryIds))
            .fetch();
    }
}