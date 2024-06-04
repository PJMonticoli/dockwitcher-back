package com.hotakakademy.dockwitcher.builders

import com.hotakakademy.dockwitcher.DTO.TractoraDto
import com.hotakakademy.dockwitcher.domain.entities.Conductor
import com.hotakakademy.dockwitcher.domain.entities.Tractora
import org.modelmapper.Converter
import org.modelmapper.spi.MappingContext

class TractoraConverter : Converter<TractoraDto, Tractora> {
    override fun convert(mappingContext: MappingContext<TractoraDto, Tractora>): Tractora {
        val tractoraDto = mappingContext.source
        val tractora = Tractora()

        tractora.matricula = tractoraDto.matricula
        tractora.modelo.marca = tractoraDto.marca
        tractora.caracteristicas.carga.pma = tractoraDto.pma?: 0
        tractora.conductor = Conductor().apply { nombre = tractoraDto.nombre }

        return tractora
    }
}