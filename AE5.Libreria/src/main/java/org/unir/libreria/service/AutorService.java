package org.unir.libreria.service;

import org.unir.libreria.model.Autor;

import java.util.List;

public interface AutorService {
    Autor getById(int id);
    List<Autor> getAll();
    List<Autor> getByName(String name);
    Autor insertOrUpdate(Autor autor);
}

