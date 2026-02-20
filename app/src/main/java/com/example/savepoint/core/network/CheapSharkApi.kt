package com.example.savepoint.core.network

import com.example.savepoint.features.deals.data.datasources.remote.model.DealDto
import com.example.savepoint.features.game.data.datasources.remote.model.GameDetailResponse
import com.example.savepoint.features.game.data.datasources.remote.model.StoreDto
import retrofit2.http.GET
import retrofit2.http.Query

interface CheapSharkApi {

    @GET("deals")
    suspend fun getDeals(
        @Query("pageSize") pageSize: Int = 20,
        @Query("sortBy") sortBy: String = "Deal Rating"
    ): List<DealDto>

    @GET("games")
    suspend fun getGameDetail(
        @Query("id") gameId: String
    ): GameDetailResponse

    @GET("stores")
    suspend fun getStores(): List<StoreDto>
}
