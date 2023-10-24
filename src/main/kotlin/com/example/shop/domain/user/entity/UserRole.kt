package com.example.shop.domain.user.entity

import com.example.shop.domain.user.enumeration.UserRoleType
import jakarta.persistence.*
import org.hibernate.annotations.Comment
import org.hibernate.annotations.DynamicUpdate
import org.springframework.data.jpa.domain.support.AuditingEntityListener

@DynamicUpdate
@EntityListeners(AuditingEntityListener::class)
@Entity
@Table(name = "t_user_role")
class UserRole(
    role: UserRoleType
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    var roleId: Long = 0L
        protected set

    @Enumerated(EnumType.STRING)
    @Comment("권한")
    @Column(name = "role", nullable = false)
    var role = role
        protected set
}