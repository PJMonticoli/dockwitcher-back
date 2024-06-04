package com.hotakakademy.dockwitcher.domain.services
import com.hotakakademy.dockwitcher.DTO.TractoraDto
import com.hotakakademy.dockwitcher.domain.entities.Tractora
import com.hotakakademy.dockwitcher.domain.factories.TractoraFactory
import com.hotakakademy.dockwitcher.domain.repositories.ITractoraRepository
import org.springframework.stereotype.Service

    @Service
    class TractoraService(
        private val tractoraFactory: TractoraFactory,
        private val repository: ITractoraRepository
    ) : ITractoraService {
        override fun create(tractoraDto: TractoraDto) {
            try {
                val tractora = tractoraFactory.createFromDto(tractoraDto)
                tractora.save()
            } catch (e: Exception) {
                throw RuntimeException("Error al crear la tractora", e)
            }
        }

        fun findAll(): List<Tractora> {
            return repository.findAll()
        }
    }
