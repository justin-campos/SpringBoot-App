package com.ram.ram.controllers;

import com.ram.ram.models.Personaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.ram.ram.service.PersonajeService;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String guardarPersonaje(RedirectAttributes redirectAttributes, @RequestParam("nombre") String nombre,
                                   @RequestParam("p1") String p1,
                                   @RequestParam("p2") String p2,
                                   @RequestParam("imgprincipal") String imgprincipal,
                                   @RequestParam("img1") String img1,
                                   @RequestParam("img2") String img2,
                                   @RequestParam("img3") String img3,
                                   Model model) {

        // Crear una instancia de Personaje con los datos del formulario
        Personaje personaje = new Personaje(nombre, p1, p2, imgprincipal, img1, img2, img3);

        // Guardar el personaje en la base de datos usando el servicio
        personajeService.guardarPersonaje(personaje);

        redirectAttributes.addFlashAttribute("mensaje", "Operación completada con éxito.");
        return "redirect:/";
    }














}
