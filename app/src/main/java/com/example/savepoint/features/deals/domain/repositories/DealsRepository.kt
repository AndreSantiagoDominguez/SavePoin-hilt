package com.example.savepoint.features.deals.domain.repositories

import com.example.savepoint.features.deals.domain.entities.Deal

interface DealsRepository {
    suspend fun getDeals(): List<Deal>
}
