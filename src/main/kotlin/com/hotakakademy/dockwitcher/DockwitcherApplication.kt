package com.hotakakademy.dockwitcher

import com.hotakakademy.dockwitcher.builders.MapperBuilder
import org.modelmapper.ModelMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class DockwitcherApplication {

	@Autowired
	private lateinit var mapperBuilder: MapperBuilder

	/* @Bean => objeto que es administrado por el contenedor de Spring
	 Spring gestiona la creación y el ciclo de vida de estos beans, lo que facilita
	 la configuración y la gestión de dependencias
	 */
	@Bean
	fun getMapper(): ModelMapper {
		return mapperBuilder.build()
	}
}

fun main(args: Array<String>) {
	runApplication<DockwitcherApplication>(*args)
}
