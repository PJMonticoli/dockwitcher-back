package com.hotakakademy.dockwitcher.domain.factories

import com.hotakakademy.dockwitcher.DTO.ConductorDto
import com.hotakakademy.dockwitcher.domain.entities.Conductor
import com.hotakakademy.dockwitcher.domain.repositories.IConductorRepository
import org.modelmapper.ModelMapper
import org.springframework.stereotype.Component

// Agregue @Component para indicarle al contenedor de Spring que debe administrar esta clase como un bean

// Los patrones de diseño Factory son utilizados para encapsular la creación de objetos,
// proporcionando una abstracción sobre el proceso de creación y permitiendo una mayor
// flexibilidad, extensibilidad y mantenibilidad del código
@Component
class ConductorFactory(
    private val repository: IConductorRepository,
    private val modelMapper: ModelMapper
): IConductorFactory {
    override fun createFromDto(conductorDto: ConductorDto): Conductor {
        val conductor = Conductor()
        conductor.setRepository(repository)
        modelMapper.map(conductorDto, conductor)
        return conductor
    }
}
