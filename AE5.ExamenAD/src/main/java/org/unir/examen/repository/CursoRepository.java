package org.unir.examen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.unir.examen.model.Curso;

import java.util.List;
import java.util.Optional;

public interface CursoRepository extends JpaRepository<Curso, Integer> {

    Optional<Curso> getByAula_Id(Integer id);

    @Query("SELECT c FROM Curso c JOIN c.profesores p WHERE p.id = :id_profesor")
    List<Curso> findCursosByProfesorId(@Param("id_profesor") Integer idProfesor);

}
