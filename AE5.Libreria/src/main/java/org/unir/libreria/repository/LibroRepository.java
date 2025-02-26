package org.unir.libreria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.unir.libreria.model.Libro;

import java.util.List;

public interface LibroRepository extends JpaRepository<Libro, Integer> {

    List<Libro> getByEditorial_Id(Integer id);

    // Consultar libros por libreria: necesita una consulta personalizada

    @Query("SELECT l FROM Libro l " +
            "JOIN l.librerias lib " +
            "WHERE lib.id = :idLibreria")
    List<Libro> getByLibreriaId(@Param("idLibreria") int idLibreria);


}
