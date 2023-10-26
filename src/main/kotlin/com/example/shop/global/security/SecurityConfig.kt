package com.example.shop.global.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer
import org.springframework.security.config.annotation.web.configurers.SessionManagementConfigurer
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class SecurityConfig {

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .csrf { csrf: CsrfConfigurer<HttpSecurity> -> csrf.disable() }
            .sessionManagement { session: SessionManagementConfigurer<HttpSecurity> -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS) }
            .formLogin { formLogin: FormLoginConfigurer<HttpSecurity> -> formLogin.disable() }
            .httpBasic { httpBasic: HttpBasicConfigurer<HttpSecurity> -> httpBasic.disable() }
            .authorizeHttpRequests { authorize ->
                authorize.anyRequest().permitAll()
            }
        return http.build()
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }
}