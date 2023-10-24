package com.example.shop.domain.user.entity

import com.example.shop.global.converter.PasswordConverter
import com.example.shop.global.entity.BaseEntity
import jakarta.persistence.*
import org.hibernate.annotations.Comment
import org.hibernate.annotations.DynamicUpdate
import org.springframework.data.jpa.domain.support.AuditingEntityListener

@DynamicUpdate
@EntityListeners(AuditingEntityListener::class)
@Entity
@Table(name = "t_user")
class User(
    userRole: UserRole,
    account: String?,
    password: String?,
    email: String?,
    nickName: String?
) : BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    var userId: Long = 0L
        protected set

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", nullable = false)
    var userRole = userRole
        protected set

    @Comment("아이디")
    @Column(name = "account", length = 50, nullable = false, unique = true)
    var account = account
        protected set

    @Comment("비밀번호")
    @Convert(converter = PasswordConverter::class)
    @Column(name = "password", nullable = false)
    var password = password
        protected set

    @Comment("이메일")
    @Column(name = "email", nullable = false, unique = true)
    var email = email
        protected set

    @Comment("활동명")
    @Column(name = "nick_name", length = 10, nullable = false, unique = true)
    var nickName = nickName
        protected set

    @Comment("인증여부")
    @Column(name = "is_auth", nullable = false, columnDefinition = "tinyint(1)")
    var isAuth: Boolean = false
        protected set

    fun isAuth(isAuth: Boolean) {
        this.isAuth = isAuth
    }
}