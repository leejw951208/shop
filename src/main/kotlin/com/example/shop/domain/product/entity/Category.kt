package com.example.shop.domain.product.entity

import com.example.shop.global.entity.BaseEntity
import jakarta.persistence.*
import org.hibernate.annotations.DynamicUpdate
import org.springframework.data.jpa.domain.support.AuditingEntityListener

@DynamicUpdate
@EntityListeners(AuditingEntityListener::class)
@Entity
@Table(name = "t_category")
class Category(
    categoryName: String?
) : BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    var categoryId: Long = 0L
        protected set

    @Column(name = "category_name")
    var categoryName = categoryName
        protected set
}