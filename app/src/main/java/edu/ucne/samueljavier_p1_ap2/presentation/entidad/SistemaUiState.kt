package edu.ucne.samueljavier_p1_ap2.presentation.entidad

import edu.ucne.samueljavier_p1_ap2.data.entity.SistemaEntity

data class SistemaUiState (
    val sistemaId: Int? = null,
    val nombre: String = "",
    val errorMessage: String? = null,
    val sistemas: List<SistemaEntity> = emptyList()
)