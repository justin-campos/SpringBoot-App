package com.ram.ram.controllers;

import com.ram.ram.data.PersonajeRepository;
import com.ram.ram.models.Personaje;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/personaje")
public class PersonajeController {

    private final PersonajeRepository personajeRepository;

    public PersonajeController(PersonajeRepository personajeRepository){
        this.personajeRepository = personajeRepository;
    }

    @GetMapping("/{id}")
    //obtengo el id
    String getPersonaje(@PathVariable long id, Model model) {
        List personajes = personajeRepository.findAll();

        System.out.println(personajes);

        if(personajes.size() < id){
            return "error";
        }

        System.out.println(id);

        int idp = (int)id;

        // Devuelve el nombre de la vista que mostrará el resultado
        model.addAttribute("personajes", personajes.get(idp));
        return "personaje";
    }


    public List<Personaje> getPersonajes(){
        return personajeRepository.findAll();
    }
}
