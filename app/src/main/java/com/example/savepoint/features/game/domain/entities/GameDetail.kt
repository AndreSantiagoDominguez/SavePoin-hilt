package com.example.savepoint.features.game.domain.entities

data class GameDetail(
    val title: String,
    val thumbUrl: String,
    val cheapestPriceEver: Double,
    val deals: List<StoreDeal>
)

data class StoreDeal(
    val storeName: String,
    val storeIconUrl: String,
    val dealId: String,
    val price: Double,
    val retailPrice: Double,
    val savingsPercent: Int
)
