package com.ram.ram.service;

import com.ram.ram.data.PersonajeRepository;
import com.ram.ram.models.Personaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonajeService {

    private final PersonajeRepository personajeRepository;

    @Autowired
    public PersonajeService(PersonajeRepository personajeRepository) {
        this.personajeRepository = personajeRepository;
    }

    public void guardarPersonaje(Personaje personaje) {
        // Imprimir información de depuración
        System.out.println("Recibiendo datos en PersonajeService:");
        // Obtener el ID generado después de guardar
        long idGenerado = personaje.getId();

        // Mostrar los datos del personaje en la consola (para verificar)
        System.out.println("ID generado: " + idGenerado);
        System.out.println(personaje);
        // Imprimir más atributos según sea necesario
        personajeRepository.save(personaje);
    }
}
