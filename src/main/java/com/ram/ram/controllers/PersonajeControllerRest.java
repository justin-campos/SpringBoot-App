package com.ram.ram.controllers;

import com.ram.ram.models.Personaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/personaje")
public class PersonajeControllerRest {

    private final PersonajeController personajeController;

    // Constructor
    @Autowired
    public PersonajeControllerRest(PersonajeController personajeController) {
        this.personajeController = personajeController;
    }

    @GetMapping("/{id}")
    // Obtengo el id
    public ResponseEntity<Personaje> getPersonaje(@PathVariable long id) {
        List<Personaje> listaDePersonajes = personajeController.getPersonajes();
        String idv = String.valueOf(id);

//        if (idv == null){
//            return "vista";
//        }
            // Puedes hacer algo con la lista de personajes aquí
            Personaje personaje = listaDePersonajes.get((int) id);
            // Devuelve la representación de cadena del objeto personaje
            return ResponseEntity.ok().body(personaje);

    }



}
