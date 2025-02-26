package org.unir.libreria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.unir.libreria.model.Libro;
import org.unir.libreria.service.LibroService;

import java.util.List;

@RestController
@RequestMapping("/libros")
public class LibroController {
    @Autowired private LibroService service;


    @GetMapping("/by-libreria")
    public ResponseEntity<List<Libro>> getByLibreria(@RequestParam int id){
        List <Libro> result  = service.getLibrosByLibreria(id);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/by-editorial")
    public ResponseEntity<List<Libro>> getByEditorial(@RequestParam int id){
        List <Libro> result  = service.getLibrosByEditorial(id);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Libro> getById(@RequestParam int id){
        Libro result = service.getById(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping()
    public ResponseEntity<Libro> insert(@RequestBody Libro body){
        Libro result = service.save(body);
        return ResponseEntity.ok(result);
    }
}
