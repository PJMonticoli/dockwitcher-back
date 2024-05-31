package com.hotakakademy.dockwitcher.domain.factories
import com.hotakakademy.dockwitcher.DTO.TractoraDto
import com.hotakakademy.dockwitcher.domain.entities.Tractora
import com.hotakakademy.dockwitcher.domain.repositories.ITractoraRepository
import org.modelmapper.ModelMapper
import org.springframework.stereotype.Component

@Component
class TractoraFactory (
    private val repository: ITractoraRepository,
    private val modelMapper: ModelMapper
): ITractoraFactory {
    override fun createFromDto(tractoraDto: TractoraDto): Tractora {
        val tractora = Tractora()
        tractora.setRepository(repository)
        modelMapper.map(tractoraDto, tractora)
        return tractora
    }
}