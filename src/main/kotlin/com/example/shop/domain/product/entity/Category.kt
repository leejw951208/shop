package com.example.shop.domain.product.entity

import com.example.shop.global.entity.BaseTimeEntity
import jakarta.persistence.*
import org.hibernate.annotations.Comment
import org.hibernate.annotations.DynamicUpdate
import org.springframework.data.jpa.domain.support.AuditingEntityListener

@DynamicUpdate
@EntityListeners(AuditingEntityListener::class)
@Entity
@Table(name = "t_category")
class Category(
    parentCategory: Category?,
    categoryName: String?,
    createdUserId: Long?,
    modifiedUserId: Long?,
) : BaseTimeEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    var categoryId: Long = 0L
        protected set

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_category_id")
    var parentCategory = parentCategory
        protected set

    @Column(name = "category_name")
    var categoryName = categoryName
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