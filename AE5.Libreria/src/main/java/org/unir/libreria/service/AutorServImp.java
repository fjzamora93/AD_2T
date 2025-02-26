package org.unir.libreria.service;


import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.unir.libreria.model.Autor;
import org.unir.libreria.repository.AutorRepository;

import java.util.List;

@Service
public class AutorServImp implements AutorService{

    @Autowired  private AutorRepository autorRepository;


    @Override
    public Autor getById(int id) {
        Autor autor = autorRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "NOT FOUND"));
        return autor;
    }

    @Override
    public List<Autor> getAll() {
        List<Autor> autors = autorRepository.findAll();
        if (autors.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "NOT FOUND");
        }
        return autors;
    }

    @Override
    public List<Autor> getByName(String name) {
        List<Autor> autors = autorRepository.getByNombre(name);
        if (autors.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "NOT FOUND");
        }
        return autors;
    }


    @Override
    public Autor insertOrUpdate(Autor autor) {
        try {
            return autorRepository.save(autor);
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error de integridad de datos: " + e.getMessage());
        }
    }

}
