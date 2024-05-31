package com.hotakakademy.dockwitcher.domain.services
import com.hotakakademy.dockwitcher.DTO.TractoraDto
import com.hotakakademy.dockwitcher.domain.entities.Tractora
import com.hotakakademy.dockwitcher.domain.factories.TractoraFactory
import com.hotakakademy.dockwitcher.domain.repositories.ITractoraRepository
import org.springframework.stereotype.Service

@Service
class TractoraService (
    private val tractoraFactory: TractoraFactory, private val repository: ITractoraRepository
) : ITractoraService {
    override fun create(tractoraDto: TractoraDto) {
        val tractora = tractoraFactory.createFromDto(tractoraDto)
        tractora.save()
    }

    fun findAll(): List<Tractora> {
        return repository.findAll()
    }

}



/*
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

 */