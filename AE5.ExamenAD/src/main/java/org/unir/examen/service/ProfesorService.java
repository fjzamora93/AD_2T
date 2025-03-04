package org.unir.examen.service;

import org.unir.examen.model.Profesor;

import java.util.List;

public interface ProfesorService {

    List<Profesor> getByCurso(int idCurso);
    Profesor insertOrUpdate(Profesor profesor);
}

