package com.hotakakademy.dockwitcher.domain.services
import com.hotakakademy.dockwitcher.DTO.ConductorDto
import com.hotakakademy.dockwitcher.domain.factories.IConductorFactory
import org.springframework.stereotype.Service
import com.hotakakademy.dockwitcher.domain.repositories.IConductorRepository
import com.hotakakademy.dockwitcher.domain.entities.Conductor

@Service
class ConductorService (
    private val conductorFactory: IConductorFactory,
) : IConductorService {
    override fun create(conductorDto: ConductorDto) {
        val conductor = conductorFactory.createFromDto(conductorDto)
        conductor.save()
    }
}

