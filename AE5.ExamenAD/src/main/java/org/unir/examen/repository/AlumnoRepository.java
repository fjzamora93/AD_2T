package org.unir.examen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.unir.examen.model.Alumno;

import java.util.List;

public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {

    List<Alumno> getByCurso_Id(int id);

}
