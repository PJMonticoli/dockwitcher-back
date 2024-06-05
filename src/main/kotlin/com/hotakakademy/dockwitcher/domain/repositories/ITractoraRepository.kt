package com.hotakakademy.dockwitcher.domain.repositories

import com.hotakademy.dockwitcher.domain.repositories.IMongoRepository
import com.hotakakademy.dockwitcher.domain.entities.Tractora

// La interfaz permite abstraer los detalles de implementación del repositorio y poder cambiar
// la implementación sin afectar a los clientes que utilizan el repositorio

// facilitan la inyección de dependencias (IoC) Los componentes pueden depender
// de interfaces en lugar de implementaciones concretas, lo que promueve la flexibilidad y la modularidad.
interface ITractoraRepository : IMongoRepository<Tractora> {
    fun findAll(): List<Tractora>
}