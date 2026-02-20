package com.example.savepoint.features.deals.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.savepoint.features.deals.domain.usecases.GetDealsUseCase
import com.example.savepoint.features.deals.presentation.screens.DealsUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DealsViewModel @Inject constructor(
    private val getDealsUseCase: GetDealsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(DealsUiState())
    val uiState = _uiState.asStateFlow()

    init {
        loadDeals()
    }

    private fun loadDeals() {
        _uiState.update { it.copy(isLoading = true) }

        viewModelScope.launch {
            val result = getDealsUseCase()
            _uiState.update { currentState ->
                result.fold(
                    onSuccess = { list ->
                        currentState.copy(isLoading = false, deals = list)
                    },
                    onFailure = { error ->
                        currentState.copy(isLoading = false, error = error.message)
                    }
                )
            }
        }
    }
}
