package com.example.savepoint.features.game.domain.usecases

import com.example.savepoint.features.game.domain.entities.GameDetail
import com.example.savepoint.features.game.domain.repositories.GameRepository
import javax.inject.Inject

class GetGameDetailUseCase @Inject constructor(
    private val repository: GameRepository
) {

    suspend operator fun invoke(gameId: String): Result<GameDetail> {
        return try {
            val gameDetail = repository.getGameDetail(gameId)

            if (gameDetail.deals.isEmpty()) {
                Result.failure(Exception("No se encontraron ofertas para este juego"))
            } else {
                Result.success(gameDetail)
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
