package com.example.savepoint.features.game.data.di

import com.example.savepoint.features.game.data.repositories.GameRepositoryImpl
import com.example.savepoint.features.game.domain.repositories.GameRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class GameRepositoryModule {

    @Binds
    @Singleton
    abstract fun bindGameRepository(
        gameRepositoryImpl: GameRepositoryImpl
    ): GameRepository
}
