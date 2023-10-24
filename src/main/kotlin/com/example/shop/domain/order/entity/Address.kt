package com.example.shop.domain.order.entity

import com.example.shop.domain.user.entity.User
import com.example.shop.global.entity.BaseEntity
import jakarta.persistence.*
import org.hibernate.annotations.Comment
import org.hibernate.annotations.DynamicUpdate
import org.springframework.data.jpa.domain.support.AuditingEntityListener

@DynamicUpdate
@EntityListeners(AuditingEntityListener::class)
@Entity
@Table(name = "t_address")
class Address(
    user: User?,
    postNumber: Int?,
    streetAddress: String?,
    detailAddress: String?
) : BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    var addressId: Long = 0L
        protected set

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    var user = user
        protected set

    @Column(name = "post_number", nullable = false)
    var postNumber = postNumber
        protected set

    @Column(name = "street_address", nullable = false)
    var streetAddress = streetAddress
        protected set

    @Column(name = "detail_address", nullable = false)
    var detailAddress = detailAddress
        protected set

    @Comment("사용여부")
    @Column(name = "is_use", nullable = false, columnDefinition = "tinyint(1)")
    var isUse: Boolean = false
        protected set
}