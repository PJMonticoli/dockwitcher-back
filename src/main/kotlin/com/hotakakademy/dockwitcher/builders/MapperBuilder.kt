package com.hotakakademy.dockwitcher.builders
import org.bson.types.ObjectId
import org.modelmapper.Converter
import org.modelmapper.ModelMapper
import org.modelmapper.config.Configuration
import org.modelmapper.convention.MatchingStrategies
import org.springframework.stereotype.Component

// Tuve que agregar selector component para que funcione mi modelmapper
@Component
class MapperBuilder {
    fun build(): ModelMapper {
        val modelMapper = ModelMapper()
        modelMapper.configuration
            .setMatchingStrategy(MatchingStrategies.STRICT)
            .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE)

        modelMapper.addConverter<String, ObjectId>(Converter<String?, ObjectId?> { applicationContext ->
            if (applicationContext.source == null) {
                return@Converter null
            }
            ObjectId(applicationContext.source)
        })

        modelMapper.addConverter<ObjectId, String>(Converter<ObjectId?, String?> { applicationContext ->
            if (applicationContext.source == null) {
                return@Converter null
            }
            applicationContext.source!!.toHexString()
        })

        modelMapper.addConverter(TractoraConverter())

        return modelMapper
    }

}
