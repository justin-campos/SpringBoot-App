package com.ram.ram.controllers;


import com.ram.ram.data.PersonajeRepository;
import com.ram.ram.models.Busqueda;
import com.ram.ram.models.Editar;
import com.ram.ram.models.Personaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class IndexController {
        private final PersonajeRepository personajeRepository;

        @Autowired
        public IndexController(PersonajeRepository personajeRepository) {
            this.personajeRepository = personajeRepository;
        }

        @RequestMapping("/")
        public String rutaPrincipal(Model model, Busqueda busqueda) {
            System.out.println("busqueda: " + busqueda.getNombre());

            List<Personaje> personajes;
            List<Personaje> todoPersonajes;
            todoPersonajes = personajeRepository.findAll();

            if (busqueda.getNombre() != null && !busqueda.getNombre().isEmpty()) {
                personajes = personajeRepository.findByNombreContaining(busqueda.getNombre());
            } else {
                personajes = todoPersonajes;
            }
            // Devuelve el nombre de la vista que mostrará el resultado
            model.addAttribute("personajes", personajes);
            model.addAttribute("todoPersonajes", todoPersonajes);
            return "index";
        }
    }


