package com.example.savepoint.features.game.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.savepoint.features.game.domain.repositories.GameRepository
import com.example.savepoint.features.game.domain.usecases.GetGameDetailUseCase
import com.example.savepoint.features.game.presentation.viewmodels.GameViewModel

class GameContainer(
    private val gameRepository: GameRepository
) {

    private val getGameDetailUseCase: GetGameDetailUseCase by lazy {
        GetGameDetailUseCase(gameRepository)
    }

    fun gameViewModelFactory(): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
            val handle = extras.createSavedStateHandle()
            return GameViewModel(getGameDetailUseCase, handle) as T
        }
    }
}
