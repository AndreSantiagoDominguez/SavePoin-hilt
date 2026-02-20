package com.example.savepoint.features.game.domain.repositories

import com.example.savepoint.features.game.domain.entities.GameDetail

interface GameRepository {
    suspend fun getGameDetail(gameId: String): GameDetail
}
