package com.hotakakademy.dockwitcher.domain.factories

import com.hotakakademy.dockwitcher.DTO.ConductorDto
import com.hotakakademy.dockwitcher.domain.entities.Conductor

interface IConductorFactory {
    fun createFromDto(conductorDto: ConductorDto): Conductor
}