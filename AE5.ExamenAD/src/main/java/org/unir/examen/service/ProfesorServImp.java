package org.unir.examen.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.unir.examen.model.Profesor;
import org.unir.examen.repository.ProfesorRepository;

import java.util.List;

@Service
public class ProfesorServImp implements ProfesorService {

    @Autowired  private ProfesorRepository repository;


    @Override
    public List<Profesor> getByCurso(int cursoId) {
        List<Profesor> entityList = repository.getByCurso(cursoId);
        if (entityList.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "NOT FOUND");
        }
        return entityList;
    }


    @Override
    public Profesor insertOrUpdate(Profesor entity) {
        try {
            return repository.save(entity);
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error de integridad de datos: " + e.getMessage());
        }
    }

}
