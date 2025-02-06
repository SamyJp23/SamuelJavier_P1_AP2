package edu.ucne.samueljavier_p1_ap2.presentation.navigation

import kotlinx.serialization.Serializable

sealed class Screen {
    @Serializable
    data object Home : Screen()

    @Serializable
    data class SistemaScreen(val sistemaId: Int) : Screen()

    @Serializable
    data object SistemaListScreen: Screen()
}