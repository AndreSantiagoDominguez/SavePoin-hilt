package com.example.savepoint.features.game.data.repositories

import com.example.savepoint.core.network.CheapSharkApi
import com.example.savepoint.features.game.data.datasources.remote.mapper.toDomain
import com.example.savepoint.features.game.domain.entities.GameDetail
import com.example.savepoint.features.game.domain.repositories.GameRepository
import javax.inject.Inject

class GameRepositoryImpl @Inject constructor(
    private val api: CheapSharkApi
) : GameRepository {

    override suspend fun getGameDetail(gameId: String): GameDetail {
        val gameResponse = api.getGameDetail(gameId)
        val stores = api.getStores()
        return gameResponse.toDomain(stores)
    }
}
