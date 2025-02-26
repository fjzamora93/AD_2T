package org.unir.libreria.service;

import org.unir.libreria.model.LibreriaEntity;

import java.util.List;

public interface LibreriaService {
    List<LibreriaEntity> getAll();
    List<LibreriaEntity> getByName(String nombre);
    LibreriaEntity getById(int id);
    LibreriaEntity insertOrUpdate(LibreriaEntity libreriaEntity);

}
