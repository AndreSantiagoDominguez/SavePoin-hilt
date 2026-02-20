package com.example.savepoint.features.deals.data.datasources.remote.mapper

import com.example.savepoint.features.deals.data.datasources.remote.model.DealDto
import com.example.savepoint.features.deals.domain.entities.Deal

fun DealDto.toDomain(): Deal {
    return Deal(
        dealId = this.dealID,
        title = this.title,
        salePrice = this.salePrice.toDoubleOrNull() ?: 0.0,
        normalPrice = this.normalPrice.toDoubleOrNull() ?: 0.0,
        savingsPercent = this.savings.toDoubleOrNull()?.toInt() ?: 0,
        metacriticScore = this.metacriticScore.toIntOrNull() ?: 0,
        dealRating = this.dealRating,
        thumbUrl = this.thumb,
        gameId = this.gameID,
        storeId = this.storeID
    )
}
