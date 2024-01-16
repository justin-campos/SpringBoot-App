package com.ram.ram.controllers;

import com.ram.ram.models.Personaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.ram.ram.service.PersonajeService;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.Map;

@Controller
@RequestMapping("/addpersonaje")
public class AddPersonajeController {

    private final PersonajeService personajeService;

    @Autowired
    public AddPersonajeController(PersonajeService personajeService) {
        this.personajeService = personajeService;
    }

    @GetMapping("/formulario")

    public String mostrarFormulario() {
        return "addpersonaje";
    }

    @PostMapping("/guardar")
    public String guardarPersonaje(Model model) {
        // Crear una instancia de Personaje sin datos del formulario (solo para pruebas)
        Personaje personaje = new Personaje("Nombre de prueba", "P1 de prueba", "P2 de prueba", "Imagen principal de prueba", "Imagen1 de prueba", "Imagen2 de prueba", "Imagen3 de prueba");

        // Guardar el personaje en la base de datos usando el servicio
        personajeService.guardarPersonaje(personaje);

        // Mostrar los datos del personaje en la consola (para verificar)
        System.out.println(personaje);

        // Redirigir a una página de confirmación
        return "index";
    }











}
