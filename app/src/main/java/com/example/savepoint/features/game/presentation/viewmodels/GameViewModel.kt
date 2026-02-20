package com.example.savepoint.features.game.presentation.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.savepoint.core.navigation.Routes
import com.example.savepoint.features.game.domain.usecases.GetGameDetailUseCase
import com.example.savepoint.features.game.presentation.screens.GameUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject constructor(
    private val getGameDetailUseCase: GetGameDetailUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val gameId: String = savedStateHandle[Routes.GAME_ID_ARG] ?: ""

    private val _uiState = MutableStateFlow(GameUiState())
    val uiState = _uiState.asStateFlow()

    init {
        loadGameDetail()
    }

    private fun loadGameDetail() {
        _uiState.update { it.copy(isLoading = true) }

        viewModelScope.launch {
            val result = getGameDetailUseCase(gameId)
            _uiState.update { currentState ->
                result.fold(
                    onSuccess = { detail ->
                        currentState.copy(isLoading = false, gameDetail = detail)
                    },
                    onFailure = { error ->
                        currentState.copy(isLoading = false, error = error.message)
                    }
                )
            }
        }
    }
}
