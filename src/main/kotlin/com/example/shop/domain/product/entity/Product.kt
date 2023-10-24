package com.example.shop.domain.product.entity

import com.example.shop.global.entity.BaseEntity
import jakarta.persistence.*
import org.hibernate.annotations.DynamicUpdate
import org.springframework.data.jpa.domain.support.AuditingEntityListener

@DynamicUpdate
@EntityListeners(AuditingEntityListener::class)
@Entity
@Table(name = "t_product")
class Product(
    category: Category?,
    productName: String?,
    price: Int?
) : BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    var productId: Long = 0L
        protected set

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    var category = category
        protected set

    @Column(name = "product_name")
    var productName = productName
        protected set

    @Column(name = "price")
    var price = price
        protected set
}