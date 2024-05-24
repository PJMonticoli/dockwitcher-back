package com.hotakakademy.dockwitcher.DTO


import com.hotakakademy.dockwitcher.domain.entities.Conductor


data class TractoraDto(
    val matricula: String,
    val modelo: String,
    val pma: Int,
    val nombre: Conductor?
)

