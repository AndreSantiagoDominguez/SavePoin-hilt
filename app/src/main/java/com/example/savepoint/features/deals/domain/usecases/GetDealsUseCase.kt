package com.example.savepoint.features.deals.domain.usecases

import com.example.savepoint.features.deals.domain.entities.Deal
import com.example.savepoint.features.deals.domain.repositories.DealsRepository
import javax.inject.Inject

class GetDealsUseCase @Inject constructor(
    private val repository: DealsRepository
) {

    suspend operator fun invoke(): Result<List<Deal>> {
        return try {
            val deals = repository.getDeals()

            val validDeals = deals.filter { it.title.isNotBlank() && it.salePrice > 0 }

            if (validDeals.isEmpty()) {
                Result.failure(Exception("No se encontraron ofertas disponibles"))
            } else {
                Result.success(validDeals)
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
