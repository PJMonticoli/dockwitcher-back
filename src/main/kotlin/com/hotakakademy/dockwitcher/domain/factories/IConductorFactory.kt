package com.hotakakademy.dockwitcher.domain.factories

import com.hotakakademy.dockwitcher.DTO.ConductorDto
import com.hotakakademy.dockwitcher.domain.entities.Conductor


// IConductorFactory para seguir el principio de inversión de dependencia, lo que
// facilita la inyección de dependencias en la aplicación
interface IConductorFactory {
    fun createFromDto(conductorDto: ConductorDto): Conductor
}