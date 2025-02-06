package edu.ucne.samueljavier_p1_ap2.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Sistemas")
data class SistemaEntity(
    @PrimaryKey
    val sistemaId: Int? = null,
    val nombre: String = ""

)