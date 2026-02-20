package com.example.savepoint.features.deals.presentation.screens

import com.example.savepoint.features.deals.domain.entities.Deal

data class DealsUiState(
    val isLoading: Boolean = false,
    val deals: List<Deal> = emptyList(),
    val error: String? = null
)
