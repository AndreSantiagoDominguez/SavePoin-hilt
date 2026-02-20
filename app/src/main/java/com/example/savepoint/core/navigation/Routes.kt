package com.example.savepoint.core.navigation

object Routes {

    // ── Argumentos ──
    const val GAME_ID_ARG = "gameId"

    // ── Rutas ──
    const val DEALS = "deals"
    const val GAME_DETAIL = "game/{$GAME_ID_ARG}"

    // ── Builders ──
    fun gameDetail(gameId: String): String = "game/$gameId"
}
