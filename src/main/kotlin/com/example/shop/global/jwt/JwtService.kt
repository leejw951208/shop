package com.example.shop.global.jwt

import com.example.shop.domain.user.entity.User
import com.example.shop.global.dto.GeneratedTokenDto
import io.jsonwebtoken.*
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.lang.IllegalArgumentException
import java.nio.charset.StandardCharsets
import java.time.Instant
import java.time.temporal.ChronoUnit
import java.util.Date
import javax.crypto.spec.SecretKeySpec

@Service
class JwtService(
    @Value("\${jwt.secret-key}")
    val secretKey: String,

    @Value("\${jwt.prefix}")
    val prefix: String,

    @Value("\${jwt.header}")
    val header: String,

    @Value("\${jwt.access-token-exp-hours}")
    val accessTokenExpHours: Long,

    @Value("\${jwt.refresh-token-exp-hours}")
    val refreshTokenExpHours: Long
) {
    fun generateToken(user: User): GeneratedTokenDto {
        val accessToken = Jwts.builder()
            .setSubject(user.userId.toString())
            .claim("role", user.userRole.role.name)
            .signWith(
                SecretKeySpec(
                    secretKey.toByteArray(StandardCharsets.UTF_8),
                    SignatureAlgorithm.HS256.jcaName
                )
            )
            .setExpiration(Date.from(Instant.now().plus(accessTokenExpHours, ChronoUnit.HOURS)))
            .compact()

        val refreshToken = Jwts.builder()
            .signWith(
                SecretKeySpec(
                    secretKey.toByteArray(StandardCharsets.UTF_8),
                    SignatureAlgorithm.HS256.jcaName
                )
            )
            .setExpiration(Date.from(Instant.now().plus(refreshTokenExpHours, ChronoUnit.HOURS)))
            .compact()
        return GeneratedTokenDto(accessToken, refreshToken)
    }

    fun verify(token: String?) {
        try {
            Jwts.parserBuilder()
                .setSigningKey(SecretKeySpec(secretKey.toByteArray(StandardCharsets.UTF_8), SignatureAlgorithm.HS256.jcaName))
                .build()
                .parseClaimsJws(token)
        } catch (e: MalformedJwtException) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, e.message)
        } catch (e: ExpiredJwtException) {
            throw ResponseStatusException(HttpStatus.UNAUTHORIZED, e.message)
        } catch (e: UnsupportedJwtException) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, e.message)
        } catch (e: IllegalArgumentException) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, e.message)
        }
    }

    private fun parseClaims(accessToken: String): Claims {
        return try {
            Jwts.parserBuilder()
                .setSigningKey(SecretKeySpec(secretKey.toByteArray(StandardCharsets.UTF_8), SignatureAlgorithm.HS256.jcaName))
                .build()
                .parseClaimsJws(accessToken)
                .body
        } catch (e: ExpiredJwtException) {
            e.claims
        }
    }
}