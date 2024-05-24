package com.hotakakademy.dockwitcher.services

import com.hotakakademy.dockwitcher.DTO.ConductorDto
import com.hotakakademy.dockwitcher.domain.entities.Conductor
import com.hotakakademy.dockwitcher.domain.repositories.IConductorRepository
import org.springframework.stereotype.Service

@Service
class ConductorService(private val repository: IConductorRepository) {

    fun createConductor(conductorDto: ConductorDto): Conductor {
        val conductor = Conductor().apply {
            nombre = conductorDto.nombre
            email = conductorDto.email
            licencia = conductorDto.licencia
            telefono = conductorDto.telefono
        }
        repository.save(conductor)
        return conductor
    }

    fun findAll(): List<Conductor> {
        return repository.findAll()
    }
}