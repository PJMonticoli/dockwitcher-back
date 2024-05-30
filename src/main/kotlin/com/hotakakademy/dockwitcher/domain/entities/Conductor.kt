package com.hotakakademy.dockwitcher.domain.entities

import com.hotakademy.dockwitcher.domain.entities.Entity
import com.hotakakademy.dockwitcher.domain.repositories.IConductorRepository
import org.springframework.data.mongodb.core.mapping.Document
import java.util.Date
@Document(collection = "conductores")
class Conductor : Entity<IConductorRepository>(){
    var nombre: String? = null
    var licencia: String? = null
    var telefono: String? = null
    var email: String? = null

    // DEJO COMENTADO PORQUE NO ME PERMITE HACER UN REGISTRO CORRECTAMENTE
    /*var indentificacion: String? = null
    var fechaCaducidad: Date? = null
    var formaciones: List<String> = mutableListOf()
    var observaciones: String? = null
    val experiencia: Experiencia = Experiencia()
    val disponibilidad: Disponibilidad = Disponibilidad()
    val historial: List<Incidentes> = mutableListOf() */
}
