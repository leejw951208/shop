package com.example.shop.domain.product.entity

import com.example.shop.global.entity.BaseEntity
import com.example.shop.global.entity.BaseTimeEntity
import jakarta.persistence.*
import org.hibernate.annotations.Comment
import org.hibernate.annotations.DynamicUpdate
import org.springframework.data.jpa.domain.support.AuditingEntityListener

@DynamicUpdate
@EntityListeners(AuditingEntityListener::class)
@Entity
@Table(name = "t_product")
class Product(
    category: Category?,
    productName: String?,
    price: Int?,
    createdUserId: Long?,
    modifiedUserId: Long?,
) : BaseTimeEntity() {
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

    @Comment("등록자")
    @Column(name = "created_user_id")
    var createdUserId = createdUserId
        protected set

    @Comment("수정자")
    @Column(name = "modified_user_id")
    var modifiedUserId = modifiedUserId
        protected set
}