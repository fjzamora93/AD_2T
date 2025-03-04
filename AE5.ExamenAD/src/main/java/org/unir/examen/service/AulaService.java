package org.unir.examen.service;

import org.unir.examen.model.Aula;

import java.util.List;

public interface AulaService {
    List<Aula> getAll();
    List<Aula> getByCapacidad();

}
