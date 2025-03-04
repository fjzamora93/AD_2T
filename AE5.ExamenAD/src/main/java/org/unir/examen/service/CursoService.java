package org.unir.examen.service;

import org.unir.examen.model.Curso;

import java.util.List;

public interface CursoService {
    Curso getById(int id);
    Curso getCursoByAula(int id);
    List<Curso> getCursosByProfesor(int id);
}
