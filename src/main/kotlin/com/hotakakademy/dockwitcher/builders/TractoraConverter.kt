package com.hotakakademy.dockwitcher.builders

import com.hotakakademy.dockwitcher.DTO.TractoraDto
import com.hotakakademy.dockwitcher.domain.entities.Conductor
import com.hotakakademy.dockwitcher.domain.entities.Tractora
import org.modelmapper.Converter
import org.modelmapper.spi.MappingContext


//  "Converter" es una interfaz de ModelMapper
class TractoraConverter : Converter<TractoraDto, Tractora> {
    // tractoraDto es el origen y Tractora destino
    override fun convert(mappingContext: MappingContext<TractoraDto, Tractora>): Tractora {
        // MappingContext tiene el objeto de origen (TractoraDto) y devuelve el objeto de destino (Tractora)
        val tractoraDto = mappingContext.source
        val tractora = Tractora()

        tractora.matricula = tractoraDto.matricula
        tractora.modelo.marca = tractoraDto.marca
        tractora.caracteristicas.carga.pma = tractoraDto.pma?: 0
        // apply lo utilizo para crear y configurar el objeto Conductor
        tractora.conductor = Conductor().apply { nombre = tractoraDto.nombre }

        return tractora
    }
}