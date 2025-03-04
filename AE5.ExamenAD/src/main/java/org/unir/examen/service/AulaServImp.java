package org.unir.examen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.unir.examen.model.Aula;
import org.unir.examen.repository.AulaRepository;

import java.util.List;
@Service

public class AulaServImp implements AulaService {
    @Autowired
    AulaRepository repository;

    @Override
    public List<Aula> getByCapacidad() {
        List<Aula> aulas = repository.getByCapacidad();
        if (aulas.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "NOT FOUND");
        }
        return aulas;
    }

    @Override
    public List<Aula> getAll() {
        List<Aula> aulas = repository.findAll();
        if (aulas.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "NOT FOUND");
        }
        return aulas;
    }



}
