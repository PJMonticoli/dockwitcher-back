package com.hotakakademy.dockwitcher.domain.factories
import com.hotakakademy.dockwitcher.DTO.TractoraDto
import com.hotakakademy.dockwitcher.domain.entities.Tractora
import com.hotakakademy.dockwitcher.domain.repositories.ITractoraRepository
import org.modelmapper.ModelMapper
import org.springframework.stereotype.Component

// Los patrones de diseño Factory son utilizados para encapsular la creación de objetos,
// proporcionando una abstracción sobre el proceso de creación y permitiendo una mayor
// flexibilidad, extensibilidad y mantenibilidad del código
@Component
class TractoraFactory(
    private val repository: ITractoraRepository,
    private val modelMapper: ModelMapper
) : ITractoraFactory {
    override fun createFromDto(tractoraDto: TractoraDto): Tractora {
        val tractora = modelMapper.map(tractoraDto, Tractora::class.java)
        tractora.setRepository(repository)
        return tractora
    }
}

