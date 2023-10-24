package com.example.shop.domain.order.entity

import com.example.shop.global.entity.BaseTimeEntity
import jakarta.persistence.*
import org.hibernate.annotations.DynamicUpdate
import org.springframework.data.jpa.domain.support.AuditingEntityListener

@DynamicUpdate
@EntityListeners(AuditingEntityListener::class)
@Entity
@Table(name = "t_delivery")
class Delivery(
    postNumber: Int?,
    streetAddress: String?,
    detailAddress: String?
) : BaseTimeEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "delivery_id")
    var deliveryId: Long = 0L
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
}