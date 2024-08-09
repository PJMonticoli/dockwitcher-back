package com.hotakakademy.dockwitcher.controllers
import com.hotakakademy.dockwitcher.DTO.ConductorDto
import com.hotakakademy.dockwitcher.domain.entities.Conductor
import com.hotakakademy.dockwitcher.domain.repositories.IConductorRepository

import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.data.domain.Page
import com.hotakakademy.dockwitcher.domain.services.IConductorService
import org.springframework.data.domain.PageRequest
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.data.domain.Sort
// @Controller para indicarle al contenedor de Spring que debe administrar esta clase como un bean
@RestController
class ConductoresController (
    private val repository: IConductorRepository,
    private val conductorService: IConductorService
) {
    @GetMapping("/conductores")
    fun listado(@RequestParam(defaultValue = "0") page: Int,
                @RequestParam(defaultValue = "10") size: Int,
                @RequestParam(defaultValue = "date") sort: String,
                @RequestParam(defaultValue = "desc") direction: String
    ): Page<Conductor>{
        val paging = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(direction), sort))
        return repository.findAll(paging)
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




