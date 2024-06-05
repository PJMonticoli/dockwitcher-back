package com.hotakakademy.dockwitcher.domain.factories

import com.hotakakademy.dockwitcher.DTO.TractoraDto
import com.hotakakademy.dockwitcher.domain.entities.Tractora

// ITractoraFactory para seguir el principio de inversión de dependencia, lo que
// facilita la inyección de dependencias en la aplicación
interface ITractoraFactory {
    fun createFromDto(tractoraDto: TractoraDto): Tractora
}