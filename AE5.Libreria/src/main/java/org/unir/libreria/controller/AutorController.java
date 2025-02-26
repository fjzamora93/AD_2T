package org.unir.libreria.controller;

import org.hibernate.annotations.Any;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.unir.libreria.model.Autor;
import org.unir.libreria.service.AutorService;

import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {


    @Autowired
    private AutorService service;

    @GetMapping("")
    public ResponseEntity<List<Autor>> getAll(){
        List <Autor> result  = service.getAll();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<Autor>> getByName(@RequestParam String name){
        List <Autor> result  = service.getByName(name);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Autor> getById(@PathVariable int id){
        Autor result = service.getById(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping()
    public ResponseEntity<Autor> insert(@RequestBody Autor body){
        Autor result = service.insertOrUpdate(body);
        return ResponseEntity.ok(result);
    }

}
