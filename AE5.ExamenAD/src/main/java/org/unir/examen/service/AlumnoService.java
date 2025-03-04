package org.unir.examen.service;

import org.unir.examen.model.Alumno;

import java.util.List;

public interface AlumnoService {
    List<Alumno> getAll();
    List<Alumno> getByCurso(int curso);
    Alumno insertOrUpdate(Alumno alumno);
}
