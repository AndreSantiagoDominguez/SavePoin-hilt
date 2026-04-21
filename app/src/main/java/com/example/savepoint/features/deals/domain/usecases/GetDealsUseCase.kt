package com.example.savepoint.features.deals.domain.usecases

import com.example.savepoint.features.deals.domain.entities.Deal
import com.example.savepoint.features.deals.domain.repositories.DealsRepository

class GetDealsUseCase(
    private val repository: DealsRepository
) {

    suspend operator fun invoke(): Result<List<Deal>> {
        return try {
            val deals = repository.getDeals()

            val uniqueDeals = deals
                .asSequence()
                .filter { it.title.isNotBlank() && it.salePrice > 0 && it.gameId.isNotBlank() }
                .sortedByDescending { it.savingsPercent }
                .distinctBy { it.gameId }
                .distinctBy { normalizeTitle(it.title) }
                .toList()

            if (uniqueDeals.isEmpty()) {
                Result.failure(Exception("No se encontraron ofertas disponibles"))
            } else {
                Result.success(uniqueDeals)
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    private fun normalizeTitle(title: String): String {
        return title
            .lowercase()
            .replace(Regex("[^a-z0-9 ]"), " ")
            .replace(
                Regex(
                    "\\b(deluxe|goty|game of the year|ultimate|definitive|" +
                        "complete|premium|gold|enhanced|remastered|collection|" +
                        "edition|bundle|pack|digital|standard)\\b"
                ),
                ""
            )
            .replace(Regex("\\s+"), " ")
            .trim()
    }
}
