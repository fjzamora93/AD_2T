package org.unir.libreria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.unir.libreria.model.Libro;
import org.unir.libreria.repository.LibroRepository;

import java.util.List;

@Service
public class LibroServImp implements LibroService {

    @Autowired
    LibroRepository libroRepository;

    @Override
    public Libro getById(int id) {
        Libro libro = libroRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "NOT FOUND"));
        return libro;
    }

    @Override
    public List<Libro> getLibrosByEditorial(int id) {
        List<Libro> libros = libroRepository.getByEditorial_Id(id);
        if (libros.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "NOT FOUND");
        }
        return libros;
    }



    @Override
    public List<Libro> getLibrosByLibreria(int idLibreria) {
        List<Libro> libros = libroRepository.getByLibreriaId(idLibreria);

        if (libros.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "NOT FOUND");
        }
        return libros;
    }

    @Override
    public Libro save(Libro libro) {
        try{
            Libro savedLibro = libroRepository.save(libro);
            return savedLibro;
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error de integridad de datos: " + e.getMessage());
        }
    }
}
