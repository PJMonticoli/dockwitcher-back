package com.hotakakademy.dockwitcher.controllers

import com.hotakakademy.dockwitcher.domain.entities.Conductor
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import com.hotakakademy.dockwitcher.domain.repositories.IConductorRepository

@Controller
class ConductoresController (
        private val repository: IConductorRepository
) {

    @GetMapping("/conductores")
    fun listado(model: Model
    ): String {
        val tractoras = repository.findAll()
        model.addAttribute("items", tractoras)
        return "listadoconductores"
    }

    @GetMapping("/conductores/registrar")
    fun nuevo(model: Model
    ): String {
        return "registrarconductor"
    }


   // @PostMapping("/conductores/registrar")
   // fun create(@ModelAttribute conductorDto: ConductorDto
   // ): String {
   //     val conductor = Conductor()
    //    conductor.nombre = conductorDto.nombre
      //  conductor.email = conductorDto.email
       // conductor.licencia = conductorDto.licencia
        //conductor.telefono = conductorDto.telefono
        //repository.save(conductor)
        //return "listadoconductores"
    //}

}