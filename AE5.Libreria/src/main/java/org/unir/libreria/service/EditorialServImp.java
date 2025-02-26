package org.unir.libreria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.unir.libreria.model.Editorial;
import org.unir.libreria.repository.EditorialRepository;

import java.util.List;

@Service

public class EditorialServImp  implements EditorialService {
    @Autowired
    EditorialRepository editorialRepository;

    @Override
    public Editorial getById(int id) {
        Editorial editorial = editorialRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Editorial no encontrado"));
        return editorial;
    }

    @Override
    public List<Editorial> getAll() {
        List<Editorial> editorials = editorialRepository.findAll();
        if (editorials.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Editorial no encontrado");
        }
        return editorials;
    }

    @Override
    public List<Editorial> getByName(String nombre) {
        List<Editorial> editorials = editorialRepository.getByNombre(nombre);
        if (editorials.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Editorial no encontrado");
        }
        return editorials;
    }

    @Override
    public Editorial save(Editorial editorial) {
        try {
            Editorial savedEditorial = editorialRepository.save(editorial);
            return savedEditorial;
        } catch ( DataIntegrityViolationException E){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error de integridad de datos: " + E.getMessage());
        }
    }
}
