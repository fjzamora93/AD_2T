package org.unir.libreria.service;

import org.unir.libreria.model.Editorial;

import java.util.List;

public interface EditorialService {
    Editorial getById(int id);
    List<Editorial> getAll();
    List<Editorial> getByName(String nombre);
    Editorial save(Editorial editorial);
}
