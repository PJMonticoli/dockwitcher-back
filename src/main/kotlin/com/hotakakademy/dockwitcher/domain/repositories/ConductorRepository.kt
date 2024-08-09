package com.hotakakademy.dockwitcher.domain.repositories

import com.hotakademy.dockwitcher.domain.repositories.AbstractMongoRepository
import com.hotakakademy.dockwitcher.domain.entities.Conductor
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.support.PageableExecutionUtils
import org.springframework.stereotype.Repository
/* @Repository  para la capa de persistencia
Se encarga de gestionar la interacción entre la aplicación y la base de datos
permitiendo separar la lógica de acceso a datos de la lógica de negocio
 */

@Repository
class ConductorRepository(
    @Qualifier("mongoMasterTemplate")
    mongoTemplate: MongoTemplate)
    : AbstractMongoRepository<Conductor>(mongoTemplate, Conductor::class.java), IConductorRepository {
    override fun findAll(paging: PageRequest): Page<Conductor> {
        val query = org.springframework.data.mongodb.core.query.Query()
        val count = mongoTemplate.count(query, Conductor::class.java)
        query.with(paging)
        val list = mongoTemplate.find(query, Conductor::class.java)
        return PageableExecutionUtils.getPage(list, paging, { count })
    }
}
