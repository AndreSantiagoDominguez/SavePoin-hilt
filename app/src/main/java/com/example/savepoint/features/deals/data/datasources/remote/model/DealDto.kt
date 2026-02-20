package com.example.savepoint.features.deals.data.datasources.remote.model

data class DealDto(
    val dealID: String,
    val title: String,
    val salePrice: String,
    val normalPrice: String,
    val savings: String,
    val metacriticScore: String,
    val steamRatingText: String?,
    val steamRatingPercent: String,
    val dealRating: String,
    val thumb: String,
    val storeID: String,
    val gameID: String,
    val releaseDate: Long,
    val steamAppID: String?
)
