package org.unir.libreria.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.unir.libreria.model.Autor;

import java.util.List;

public interface AutorRepository extends JpaRepository<Autor, Integer> {

    @Query("SELECT x FROM Autor x WHERE x.nombre LIKE %:name%")
    List<Autor> getByNombre(@Param("name") String name);


    List<Autor> getByFechaNacimiento(String fecha);

}
