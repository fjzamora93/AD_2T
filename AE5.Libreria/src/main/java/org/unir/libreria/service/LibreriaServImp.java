package org.unir.libreria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.unir.libreria.model.LibreriaEntity;
import org.unir.libreria.repository.LibreriaRepository;

import java.util.List;
@Service

public class LibreriaServImp implements LibreriaService {
    @Autowired
    LibreriaRepository repository;

    @Override
    public List<LibreriaEntity> getAll() {
        List<LibreriaEntity> librerias = repository.findAll();
        if (librerias.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "NOT FOUND");
        }
        return librerias;
    }

    @Override
    public List<LibreriaEntity> getByName(String nombre) {
        List<LibreriaEntity> librerias = repository.getByNombre(nombre);
        if (librerias.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "NOT FOUND");
        }
        return librerias;
    }

    @Override
    public LibreriaEntity getById(int id) {
        LibreriaEntity libreria = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "NOT FOUND"));
        return libreria;
    }

    @Override
    public LibreriaEntity insertOrUpdate(LibreriaEntity libreriaEntity) {
        try {
            LibreriaEntity libreria = repository.save(libreriaEntity);
            return libreria;
        } catch (DataIntegrityViolationException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error de integridad de datos: " + e.getMessage());
        }
    }
}
