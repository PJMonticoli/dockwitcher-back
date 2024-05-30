package com.hotakakademy.dockwitcher.domain.repositories

import com.hotakademy.dockwitcher.domain.repositories.IMongoRepository
import com.hotakakademy.dockwitcher.domain.entities.Conductor



interface IConductorRepository : IMongoRepository<Conductor> {
    fun findAll(): List<Conductor>
}
