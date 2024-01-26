package com.ram.ram.controllers;

import com.ram.ram.data.PersonajeRepository;
import com.ram.ram.models.Borrar;
import com.ram.ram.models.Editar;
import com.ram.ram.models.Personaje;
import com.ram.ram.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class TablaController {

    private final PersonajeRepository personajeRepository;
    private final PersonajeService personajeService; // Agregado

    @Autowired
    public TablaController(PersonajeRepository personajeRepository, PersonajeService personajeService) {
        this.personajeRepository = personajeRepository;
        this.personajeService = personajeService; // Inyectar el servicio
    }

    @RequestMapping("/tabla")
    public String rutaPrincipal(Model model) {
        List personajes = personajeRepository.findAll();

        // Devuelve el nombre de la vista que mostrará el resultado
        model.addAttribute("personajes", personajes);
        return "tabla";
    }

    @PostMapping("/borrar")
    public String guardarPersonaje(Borrar borrar, RedirectAttributes redirectAttributes) {
        System.out.println("id para borrar"+ borrar.getId());
        personajeRepository.deleteById(borrar.getId()); // Utiliza la instancia, no la clase
        redirectAttributes.addFlashAttribute("mensaje", "Operación completada con éxito.");


        return "redirect:/tabla";
    }
    @PostMapping("/editar/{id}")
    public String editarPersonaje(@PathVariable Long id, Editar editar, RedirectAttributes redirectAttributes) {

        personajeService.actualizarPersonaje(id, editar);
        System.out.println("Personaje editado" + id + editar);
        redirectAttributes.addFlashAttribute("mensaje", "Personaje Actualizado con exito!");

        return "redirect:/tabla";
    }
}
