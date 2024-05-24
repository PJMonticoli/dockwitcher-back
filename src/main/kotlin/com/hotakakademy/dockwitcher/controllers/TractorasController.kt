package com.hotakakademy.dockwitcher.controllers

import com.hotakakademy.dockwitcher.DTO.TractoraDto
import com.hotakakademy.dockwitcher.domain.repositories.ITractoraRepository
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import com.hotakakademy.dockwitcher.domain.entities.Tractora
import com.hotakakademy.dockwitcher.services.TractoraService

@Controller
class TractorasController (    private val tractoraService: TractoraService
) {
    @GetMapping("/tractoras")
    fun listadoRecogidas(model: Model): String {
        val tractoras = tractoraService.findAll()
        model.addAttribute("tractoras", tractoras)
        return "listadotractoras"
    }

    @GetMapping("/tractoras/registrar")
    fun mostrarFormularioRegistro(model: Model): String {
        model.addAttribute("tractora", Tractora())
        return "registrartractora"
    }

    @PostMapping("/tractoras/registrar")
    fun crearTractora(@ModelAttribute tractoraDto: TractoraDto): String {
        tractoraService.createTractora(tractoraDto)
        return "redirect:/tractoras"
    }


}

// private val repository: ITractoraRepository
/* @GetMapping("/tractoras")
 fun listadoRecogidas(model: Model
 ): String {
     val tractoras = repository.findAll()
     model.addAttribute("tractoras", tractoras)
     model.addAttribute("tractora", Tractora()) // Para el formulario de creación
     return "listadotractoras"
 }
 @GetMapping("/tractoras/registrar")
 fun mostrarFormularioRegistro(model: Model): String {
     model.addAttribute("tractora", Tractora())
     return "registrartractora"
 }

 @PostMapping("/tractoras/registrar")
 fun crearTractora(@ModelAttribute tractora: Tractora): String {
     repository.save(tractora)
     return "redirect:/tractoras"
 }

*/