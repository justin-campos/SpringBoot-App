package com.ram.ram.service;

import com.ram.ram.data.PersonajeRepository;
import com.ram.ram.models.Personaje;
import com.ram.ram.models.Editar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;

@Service
public class PersonajeService {

    private final PersonajeRepository personajeRepository;

    @Autowired
    public PersonajeService(PersonajeRepository personajeRepository) {
        this.personajeRepository = personajeRepository;
    }

    public void guardarPersonaje(Personaje personaje) {
        // Imprimir en la consola los valores que se esperan en el modelo
        System.out.println("Nombre en el controlador: " + personaje.getNombre());

        personajeRepository.save(personaje);
    }

    public void actualizarPersonaje(Long id, Editar editar) {

        // Buscar el personaje por su ID
        Optional<Personaje> optionalPersonaje = personajeRepository.findById(id);

        System.out.println(optionalPersonaje);

        if (optionalPersonaje.isPresent()) {
            // Si el personaje con el ID proporcionado existe, actualiza sus campos
            Personaje personajeExistente = optionalPersonaje.get();
            personajeExistente.setNombre(editar.getNombre());
            personajeExistente.setImg1(editar.getImg1());
            personajeExistente.setImg2(editar.getImg2());
            personajeExistente.setImg3(editar.getImg3());
            personajeExistente.setP1(editar.getP1());
            personajeExistente.setP2(editar.getP2());
            personajeExistente.setImgprincipal(editar.getImgprincipal());
            // Actualiza otros campos según sea necesario...

            // Guarda la entidad actualizada en la base de datos
            personajeRepository.save(personajeExistente);
        } else {
            // Si no se encuentra el personaje con el ID proporcionado
            throw new RuntimeException("Personaje no encontrado para el ID: " + id);
        }
    }

}
