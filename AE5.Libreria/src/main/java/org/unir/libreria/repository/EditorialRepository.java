package org.unir.libreria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.unir.libreria.model.Editorial;

import java.util.List;

public interface EditorialRepository extends JpaRepository<Editorial, Integer> {

    List<Editorial> getByNombre(String name);
}
