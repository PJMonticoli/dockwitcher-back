package com.hotakakademy.dockwitcher.domain.repositories

import com.hotakademy.dockwitcher.domain.repositories.AbstractMongoRepository
import com.hotakakademy.dockwitcher.domain.entities.Conductor
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.stereotype.Repository

@Repository
class ConductorRepository(
    @Qualifier("mongoMasterTemplate")
    mongoTemplate: MongoTemplate)
    : AbstractMongoRepository<Conductor>(mongoTemplate, Conductor::class.java), IConductorRepository {

    override fun save(entity: Conductor) {
        mongoTemplate.save(entity)
    }

    override fun findAll(): List<Conductor> {
        return mongoTemplate.findAll(Conductor::class.java)
    }
}
