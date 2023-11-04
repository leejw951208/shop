package com.example.shop

import com.example.shop.domain.product.entity.Product
import com.example.shop.domain.product.repository.CategoryRepository
import com.example.shop.domain.product.repository.ProductRepository
import com.example.shop.domain.product.service.ProductService
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
class ProductTests @Autowired constructor(
    private val productRepository: ProductRepository,
    private val categoryRepository: CategoryRepository,
    private val productService: ProductService
) {
    @Test
    @DisplayName("상품 더미 데이터 등록 테스트")
    @Transactional
//    @Rollback(false)
    fun init() {
        val findTop1 = categoryRepository.findByIdOrNull(9)
        productRepository.save(Product(findTop1, "하늘색 셔츠", 30000, null, null))
        productRepository.save(Product(findTop1, "베이지색 셔츠", 35000, null, null))

        val findTop2 = categoryRepository.findByIdOrNull(10)
        productRepository.save(Product(findTop2, "검정색 맨투맨", 28000, null, null))
        productRepository.save(Product(findTop2, "네이비색 맨투맨", 31000, null, null))

        val findBottom1 = categoryRepository.findByIdOrNull(12)
        productRepository.save(Product(findBottom1, "밝은 청바지", 42000, null, null))
        productRepository.save(Product(findBottom1, "회색 청바지", 40000, null, null))

        val findBottom2 = categoryRepository.findByIdOrNull(13)
        productRepository.save(Product(findBottom2, "청반바지", 22000, null, null))
        productRepository.save(Product(findBottom2, "면반바지", 24000, null, null))
    }

    @Test
    @Transactional
    @DisplayName("카테고리 별 전체 상품 조회 테스트")
    fun findByParentCategoryId() {
        val findProducts = productService.findProductsByParentCategoryId(8L)
        for (findProduct in findProducts) {
            println(findProduct)
        }
    }

    @Test
    @Transactional
    @DisplayName("상세 카테고리 별 전체 상품 조회 테스트")
    fun findByCategoryId() {
        val findProducts = productService.findProductsByCategoryId(9L)
        for (findProduct in findProducts) {
            println(findProduct)
        }
    }
}