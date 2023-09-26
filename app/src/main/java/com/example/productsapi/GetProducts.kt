package com.example.productsapi

data class GetProducts(
    val limit: Int,
    val products: List<Product>,
    val skip: Int,
    val total: Int
)