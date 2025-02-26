package org.unir.libreria.service;

import org.unir.libreria.model.Libro;

import java.util.List;

public interface LibroService {
    Libro getById(int id);
    List<Libro> getLibrosByEditorial(int id);
    List<Libro> getLibrosByLibreria(int id);
    Libro save(Libro libro);

}
