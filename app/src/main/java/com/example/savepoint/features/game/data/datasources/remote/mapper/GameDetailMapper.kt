package com.example.savepoint.features.game.data.datasources.remote.mapper

import com.example.savepoint.features.game.data.datasources.remote.model.GameDealDto
import com.example.savepoint.features.game.data.datasources.remote.model.GameDetailResponse
import com.example.savepoint.features.game.data.datasources.remote.model.StoreDto
import com.example.savepoint.features.game.domain.entities.GameDetail
import com.example.savepoint.features.game.domain.entities.StoreDeal

fun GameDetailResponse.toDomain(stores: List<StoreDto>): GameDetail {
    val storeMap = stores.associateBy { it.storeID }

    return GameDetail(
        title = this.info.title,
        thumbUrl = buildArtworkUrl(this.info.steamAppID, this.info.thumb),
        cheapestPriceEver = this.cheapestPriceEver.price.toDoubleOrNull() ?: 0.0,
        deals = this.deals.map { it.toDomain(storeMap) }
    )
}

fun GameDealDto.toDomain(storeMap: Map<String, StoreDto>): StoreDeal {
    val store = storeMap[this.storeID]
    return StoreDeal(
        storeName = store?.storeName ?: "Tienda #${this.storeID}",
        storeIconUrl = "https://www.cheapshark.com${store?.images?.icon ?: ""}",
        dealId = this.dealID,
        price = this.price.toDoubleOrNull() ?: 0.0,
        retailPrice = this.retailPrice.toDoubleOrNull() ?: 0.0,
        savingsPercent = this.savings.toDoubleOrNull()?.toInt() ?: 0
    )
}

private fun buildArtworkUrl(steamAppID: String?, fallback: String): String {
    val appId = steamAppID?.takeIf { it.isNotBlank() } ?: return fallback
    return "https://cdn.cloudflare.steamstatic.com/steam/apps/$appId/header.jpg"
}
