package com.example.savepoint.features.game.presentation.screens

import com.example.savepoint.features.game.domain.entities.GameDetail

data class GameUiState(
    val isLoading: Boolean = false,
    val gameDetail: GameDetail? = null,
    val error: String? = null
)
