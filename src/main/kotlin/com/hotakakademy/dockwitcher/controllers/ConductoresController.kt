package com.hotakakademy.dockwitcher.controllers

import com.hotakakademy.dockwitcher.domain.entities.Conductor
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import com.hotakakademy.dockwitcher.domain.repositories.IConductorRepository
import org.springframework.web.bind.annotation.PostMapping
@Controller
class ConductoresController (
    private val repository: IConductorRepository
) {

    @GetMapping("/conductores")
    fun listadoRecogidas(model: Model
    ): String {
        val conductores = repository.findAll()
        model.addAttribute("conductores", conductores)
        return "listadoconductores"
    }

    @GetMapping("/conductores/registrar")
    fun nuevo(model: Model): String {
        return "registrarconductor"
    }

}