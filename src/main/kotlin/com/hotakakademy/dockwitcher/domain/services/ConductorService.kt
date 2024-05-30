package com.hotakakademy.dockwitcher.domain.services
import com.hotakakademy.dockwitcher.DTO.ConductorDto
import com.hotakakademy.dockwitcher.domain.factories.IConductorFactory
import org.springframework.stereotype.Service
import com.hotakakademy.dockwitcher.domain.repositories.IConductorRepository
import com.hotakakademy.dockwitcher.domain.entities.Conductor


@Service
class ConductorService (
    private val conductorFactory: IConductorFactory,private val repository: IConductorRepository
) : IConductorService {
    override fun create(conductorDto: ConductorDto) {
        val conductor = conductorFactory.createFromDto(conductorDto)
        conductor.save()
    }
    fun findAll(): List<Conductor> {
        return repository.findAll()
    }
}


/*

CODIGO VIEJO
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

 */