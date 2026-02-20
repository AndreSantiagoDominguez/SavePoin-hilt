package com.example.savepoint.features.deals.data.repositories

import com.example.savepoint.core.network.CheapSharkApi
import com.example.savepoint.features.deals.data.datasources.remote.mapper.toDomain
import com.example.savepoint.features.deals.domain.entities.Deal
import com.example.savepoint.features.deals.domain.repositories.DealsRepository
import javax.inject.Inject

class DealsRepositoryImpl @Inject constructor(
    private val api: CheapSharkApi
) : DealsRepository {

    override suspend fun getDeals(): List<Deal> {
        val response = api.getDeals()
        return response.map { it.toDomain() }
    }
}
