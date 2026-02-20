package com.example.savepoint.features.deals.data.di

import com.example.savepoint.features.deals.data.repositories.DealsRepositoryImpl
import com.example.savepoint.features.deals.domain.repositories.DealsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DealsRepositoryModule {

    @Binds
    @Singleton
    abstract fun bindDealsRepository(
        dealsRepositoryImpl: DealsRepositoryImpl
    ): DealsRepository
}
