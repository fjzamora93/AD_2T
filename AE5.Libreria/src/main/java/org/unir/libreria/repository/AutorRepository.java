package org.unir.libreria.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.unir.libreria.model.Autor;

import java.util.List;

public interface AutorRepository extends JpaRepository<Autor, Integer> {

    List<Autor> getByNombre(String name);
    List<Autor> getByFechaNacimiento(String fecha);

}
