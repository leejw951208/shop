package com.example.shop

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

inline fun <reified T> T.logger(): Logger {
	if (T::class.isCompanion) {
		return LoggerFactory.getLogger(T::class.java.enclosingClass)
	}
	return LoggerFactory.getLogger(T::class.java)
}

@EnableJpaAuditing
@SpringBootApplication
class ShopApplication

fun main(args: Array<String>) {
	runApplication<ShopApplication>(*args)
}
