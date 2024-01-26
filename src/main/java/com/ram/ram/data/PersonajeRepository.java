package com.ram.ram.data;

import com.ram.ram.models.Personaje;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonajeRepository extends JpaRepository<Personaje, Long> {
    void deleteById(Long id);

    List<Personaje> findByNombreContaining(String nombre);

}
