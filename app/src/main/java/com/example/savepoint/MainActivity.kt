package com.example.savepoint

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.savepoint.core.navigation.Routes
import com.example.savepoint.core.ui.theme.SavePointTheme
import com.example.savepoint.features.deals.presentation.screens.DealsScreen
import com.example.savepoint.features.game.presentation.screens.GameDetailScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SavePointTheme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = Routes.DEALS
                ) {
                    composable(Routes.DEALS) {
                        DealsScreen(
                            onDealClick = { gameId ->
                                navController.navigate(Routes.gameDetail(gameId))
                            }
                        )
                    }

                    composable(
                        route = Routes.GAME_DETAIL,
                        arguments = listOf(
                            navArgument(Routes.GAME_ID_ARG) { type = NavType.StringType }
                        )
                    ) {
                        GameDetailScreen(
                            onBack = { navController.popBackStack() }
                        )
                    }
                }
            }
        }
    }
}
