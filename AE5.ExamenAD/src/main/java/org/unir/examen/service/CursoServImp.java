package org.unir.examen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.unir.examen.model.Curso;
import org.unir.examen.repository.CursoRepository;

import java.util.List;

@Service
public class CursoServImp implements CursoService {

    @Autowired
    CursoRepository repository;

    @Override
    public Curso getById(int id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "NOT FOUND"));
    }

    @Override
    public Curso getCursoByAula(int id) {
        return repository
                .getByAula_Id(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "NOT FOUND"));
    }



    @Override
    public List<Curso> getCursosByProfesor(int idProfesor) {
        List<Curso> entityList = repository.findCursosByProfesorId(idProfesor);

        if (entityList.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "NOT FOUND");
        }
        return entityList;
    }

}
