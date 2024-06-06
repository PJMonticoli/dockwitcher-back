package com.hotakakademy.dockwitcher.controllers
import com.hotakakademy.dockwitcher.DTO.ConductorDto
import com.hotakakademy.dockwitcher.domain.repositories.IConductorRepository
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

import com.hotakakademy.dockwitcher.domain.services.IConductorService
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping

// @Controller para indicarle al contenedor de Spring que debe administrar esta clase como un bean
@Controller
class ConductoresController (
    private val repository: IConductorRepository,
    private val conductorService: IConductorService
) {

    @GetMapping("/conductores")
    fun listado(model: Model): String {
        val conductores = repository.findAll()
        model.addAttribute("conductores", conductores)
        return "listadoconductores"
    }

    @GetMapping("/conductores/registrar")
    fun nuevo(model: Model): String {
        return "registrarconductor"
    }


    @PostMapping("/conductores/registrar")
    fun create(@ModelAttribute conductorDto: ConductorDto
    ): String {
        return try {
            conductorService.create(conductorDto)
            "redirect:/conductores"
        } catch (e: Exception) {
            println("Error: ${e.message}")
            "error"
        }
    }

}




