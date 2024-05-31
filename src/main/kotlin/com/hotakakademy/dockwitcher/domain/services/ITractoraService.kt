package com.hotakakademy.dockwitcher.domain.services
import com.hotakakademy.dockwitcher.DTO.TractoraDto

interface ITractoraService {
    fun create(tractoraDto: TractoraDto)
}