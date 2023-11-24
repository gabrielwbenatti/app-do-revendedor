package br.com.gwbenatti.appdorevendedor.domain.model

data class Product(
    val id: Int = 0,
    val name: String = "",
    val salePrice: Double = 0.00,
    val promotionalSalePrice: Double? = 0.00,
    val family: Family? = null,
    val group: Group? = null,
)
