package com.hotakakademy.dockwitcher.controllers

import com.hotakakademy.dockwitcher.domain.entities.Conductor
import com.hotakakademy.dockwitcher.domain.repositories.ITractoraRepository
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import com.hotakakademy.dockwitcher.domain.entities.Tractora
import com.hotakakademy.dockwitcher.domain.repositories.IConductorRepository

@Controller
class ConductoresController (
        private val repository: IConductorRepository
) {

    @GetMapping("/conductores")
    fun listadoConductores(model: Model
    ): String {
        val conductores = repository.findAll()
        model.addAttribute("conductores", conductores)
        return "listadoconductores"
    }

    @PostMapping("/conductores/registrar")
    fun crearConductor(@ModelAttribute conductor: Conductor): String {
        repository.save(conductor)
        return "redirect:/conductor"
    }
}