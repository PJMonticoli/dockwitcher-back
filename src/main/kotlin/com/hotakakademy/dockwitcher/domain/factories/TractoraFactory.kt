package com.hotakakademy.dockwitcher.domain.factories
import com.hotakakademy.dockwitcher.DTO.TractoraDto
import com.hotakakademy.dockwitcher.domain.entities.Conductor
import com.hotakakademy.dockwitcher.domain.entities.Tractora
import com.hotakakademy.dockwitcher.domain.repositories.ITractoraRepository
import org.modelmapper.ModelMapper
import org.springframework.stereotype.Component

@Component
class TractoraFactory(
    private val repository: ITractoraRepository,
    private val modelMapper: ModelMapper
) : ITractoraFactory {
    // MAPEO TEMPORAL
    override fun createFromDto(tractoraDto: TractoraDto): Tractora {
        val tractora = Tractora()
        tractora.setRepository(repository)
        tractora.matricula = tractoraDto.matricula
        tractora.modelo.marca = tractoraDto.marca
        tractora.caracteristicas.carga.pma = tractoraDto.pma ?: 0
        tractora.conductor = Conductor().apply { nombre = tractoraDto.nombre }

        return tractora
    }
}
