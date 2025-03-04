package org.unir.examen.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.unir.examen.model.Profesor;

import java.util.List;

public interface ProfesorRepository extends JpaRepository<Profesor, Integer> {


    @Query( "SELECT p FROM Profesor p JOIN p.cursos WHERE p.id = :id_curso" )
    List<Profesor> getByCurso(@Param("id_curso") Integer idCurso);



}
