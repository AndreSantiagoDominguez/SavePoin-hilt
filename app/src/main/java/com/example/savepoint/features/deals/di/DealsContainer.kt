package com.example.savepoint.features.deals.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.savepoint.features.deals.domain.repositories.DealsRepository
import com.example.savepoint.features.deals.domain.usecases.GetDealsUseCase
import com.example.savepoint.features.deals.presentation.viewmodels.DealsViewModel

class DealsContainer(
    private val dealsRepository: DealsRepository
) {

    private val getDealsUseCase: GetDealsUseCase by lazy {
        GetDealsUseCase(dealsRepository)
    }

    fun dealsViewModelFactory(): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return DealsViewModel(getDealsUseCase) as T
        }
    }
}
