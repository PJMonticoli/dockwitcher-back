package com.hotakakademy.dockwitcher.domain.services

import com.hotakakademy.dockwitcher.DTO.ConductorDto



interface IConductorService {
    fun create(conductorDto: ConductorDto)
}