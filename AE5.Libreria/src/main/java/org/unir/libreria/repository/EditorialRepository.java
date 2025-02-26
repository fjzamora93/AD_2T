package org.unir.libreria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.unir.libreria.model.Editorial;

import java.util.List;

public interface EditorialRepository extends JpaRepository<Editorial, Integer> {
    @Query("SELECT x FROM Editorial x WHERE x.nombre LIKE %:name%")
    List<Editorial> getByNombre(@Param("name") String name);
}
