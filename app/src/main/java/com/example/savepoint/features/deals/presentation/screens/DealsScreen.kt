package com.example.savepoint.features.deals.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.savepoint.features.deals.presentation.components.DealCard
import com.example.savepoint.features.deals.presentation.viewmodels.DealsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DealsScreen(
    onDealClick: (gameId: String) -> Unit,
    viewModel: DealsViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "\uD83C\uDFAE SavePoint",
                        fontWeight = FontWeight.ExtraBold
                    )
                }
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            when {
                uiState.isLoading -> {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }
                uiState.error != null -> {
                    Text(
                        text = uiState.error ?: "Error desconocido",
                        modifier = Modifier.align(Alignment.Center),
                        color = Color.Red
                    )
                }
                uiState.deals.isEmpty() -> {
                    Text(
                        text = "No hay ofertas disponibles",
                        modifier = Modifier.align(Alignment.Center),
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
                else -> {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        contentPadding = PaddingValues(vertical = 8.dp)
                    ) {
                        items(uiState.deals) { deal ->
                            DealCard(
                                title = deal.title,
                                salePrice = deal.salePrice,
                                normalPrice = deal.normalPrice,
                                savingsPercent = deal.savingsPercent,
                                thumbUrl = deal.thumbUrl,
                                onClick = { onDealClick(deal.gameId) }
                            )
                        }
                    }
                }
            }
        }
    }
}
