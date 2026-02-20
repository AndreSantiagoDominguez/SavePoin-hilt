package com.example.savepoint.features.game.data.datasources.remote.model

data class GameDetailResponse(
    val info: GameInfoDto,
    val cheapestPriceEver: CheapestPriceDto,
    val deals: List<GameDealDto>
)

data class GameInfoDto(
    val title: String,
    val steamAppID: String?,
    val thumb: String
)

data class CheapestPriceDto(
    val price: String,
    val date: Long
)

data class GameDealDto(
    val storeID: String,
    val dealID: String,
    val price: String,
    val retailPrice: String,
    val savings: String
)

data class StoreDto(
    val storeID: String,
    val storeName: String,
    val isActive: Int,
    val images: StoreImagesDto
)

data class StoreImagesDto(
    val banner: String,
    val logo: String,
    val icon: String
)
