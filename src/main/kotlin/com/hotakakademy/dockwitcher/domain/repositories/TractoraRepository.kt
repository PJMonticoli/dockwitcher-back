package com.hotakakademy.dockwitcher.domain.repositories

import com.hotakademy.dockwitcher.domain.repositories.AbstractMongoRepository
import com.hotakakademy.dockwitcher.domain.entities.Tractora
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.stereotype.Repository

@Repository
class TractoraRepository(
    @Qualifier("mongoMasterTemplate")
    mongoTemplate: MongoTemplate)
    : AbstractMongoRepository<Tractora>(mongoTemplate, Tractora::class.java), ITractoraRepository {

    override fun save(entity: Tractora) {
        mongoTemplate.save(entity)
    }

    override fun findAll(): List<Tractora> {
        return mongoTemplate.findAll(Tractora::class.java)
    }
}
