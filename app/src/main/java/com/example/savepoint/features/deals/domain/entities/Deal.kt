package com.example.savepoint.features.deals.domain.entities

data class Deal(
    val dealId: String,
    val title: String,
    val salePrice: Double,
    val normalPrice: Double,
    val savingsPercent: Int,
    val metacriticScore: Int,
    val dealRating: String,
    val thumbUrl: String,
    val gameId: String,
    val storeId: String
)
