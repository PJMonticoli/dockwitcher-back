package com.hotakakademy.dockwitcher.domain.factories

import com.hotakakademy.dockwitcher.DTO.TractoraDto
import com.hotakakademy.dockwitcher.domain.entities.Tractora

interface ITractoraFactory {
    fun createFromDto(tractoraDto: TractoraDto): Tractora
}