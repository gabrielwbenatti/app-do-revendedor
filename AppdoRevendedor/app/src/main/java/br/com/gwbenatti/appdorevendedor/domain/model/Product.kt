package br.com.gwbenatti.appdorevendedor.domain.model

data class Product(
    val id: Int,
    val name: String,
    val salePrice: Double,
    val promotionalSalePrice: Double?,
)
