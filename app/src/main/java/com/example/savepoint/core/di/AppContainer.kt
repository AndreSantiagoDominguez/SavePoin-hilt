package com.example.savepoint.core.di

import com.example.savepoint.core.network.CheapSharkApi
import com.example.savepoint.features.deals.data.repositories.DealsRepositoryImpl
import com.example.savepoint.features.deals.di.DealsContainer
import com.example.savepoint.features.deals.domain.repositories.DealsRepository
import com.example.savepoint.features.game.data.repositories.GameRepositoryImpl
import com.example.savepoint.features.game.di.GameContainer
import com.example.savepoint.features.game.domain.repositories.GameRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AppContainer {

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://www.cheapshark.com/api/1.0/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private val api: CheapSharkApi by lazy {
        retrofit.create(CheapSharkApi::class.java)
    }

    private val dealsRepository: DealsRepository by lazy {
        DealsRepositoryImpl(api)
    }

    private val gameRepository: GameRepository by lazy {
        GameRepositoryImpl(api)
    }

    val dealsContainer: DealsContainer by lazy {
        DealsContainer(dealsRepository)
    }

    val gameContainer: GameContainer by lazy {
        GameContainer(gameRepository)
    }
}
