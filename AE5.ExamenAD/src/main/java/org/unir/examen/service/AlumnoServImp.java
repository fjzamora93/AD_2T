package org.unir.examen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.unir.examen.model.Alumno;
import org.unir.examen.repository.AlumnoRepository;

import java.util.List;

@Service

public class AlumnoServImp implements AlumnoService {
    @Autowired
    AlumnoRepository repository;


    @Override
    public List<Alumno> getAll() {
        List<Alumno> entityList = repository.findAll();
        if (entityList.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "NO encontrado");
        }
        return entityList;
    }

    @Override
    public List<Alumno> getByCurso(int cursoId) {
        List<Alumno> entityList = repository.getByCurso_Id(cursoId);
        if (entityList.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "NO encontrado");
        }
        return entityList;
    }

    @Override
    public Alumno insertOrUpdate(Alumno entity) {
        try {
            return repository.save(entity);
        } catch ( DataIntegrityViolationException E){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error de integridad de datos: " + E.getMessage());
        }
    }
}
