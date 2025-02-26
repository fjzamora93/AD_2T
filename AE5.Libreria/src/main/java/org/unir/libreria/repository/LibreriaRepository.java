package org.unir.libreria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.unir.libreria.model.LibreriaEntity;

import java.util.List;

public interface LibreriaRepository extends JpaRepository<LibreriaEntity, Integer> {
    List<LibreriaEntity> getByNombre(String nombre);
}
