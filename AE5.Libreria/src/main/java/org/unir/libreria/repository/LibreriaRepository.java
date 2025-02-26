package org.unir.libreria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.unir.libreria.model.LibreriaEntity;

import java.util.List;

public interface LibreriaRepository extends JpaRepository<LibreriaEntity, Integer> {

    @Query("SELECT x FROM LibreriaEntity x WHERE x.nombre LIKE %:name%")
    List<LibreriaEntity> getByNombre(@Param("name") String name);
}
