package org.unir.examen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.unir.examen.model.Aula;

import java.util.List;

public interface AulaRepository extends JpaRepository<Aula, Integer> {

    @Query ("SELECT a FROM Aula a WHERE a.capacidad > 30 ")
    List<Aula> getByCapacidad();

}
