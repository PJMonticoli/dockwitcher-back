package com.hotakakademy.dockwitcher.domain.services

import com.hotakakademy.dockwitcher.DTO.TractoraDto
import com.hotakakademy.dockwitcher.domain.entities.Tractora
import com.hotakakademy.dockwitcher.domain.repositories.ITractoraRepository
import org.springframework.stereotype.Service

@Service
class TractoraService(
    private val tractoraRepository: ITractoraRepository,
) {

    fun createTractora(tractoraDto: TractoraDto): Tractora {
        val tractora = Tractora().apply {
            matricula = tractoraDto.matricula
            modelo.marca = tractoraDto.marca
            caracteristicas.carga.pma = tractoraDto.pma
            conductor = tractoraDto.nombre
        }
        tractoraRepository.save(tractora)
        return tractora
    }

    fun findAll(): List<Tractora> {
        return tractoraRepository.findAll()
    }
}