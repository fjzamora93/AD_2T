package org.unir.libreria.controller;

import org.hibernate.annotations.Any;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.unir.libreria.model.Autor;
import org.unir.libreria.model.LibreriaEntity;
import org.unir.libreria.service.AutorService;
import org.unir.libreria.service.LibreriaService;

import java.util.List;

@RestController
@RequestMapping("/librerias")
public class LibreriaController {
    @Autowired
    private LibreriaService service;


    @GetMapping("")
    public ResponseEntity<List<LibreriaEntity>> getAll(){
        List <LibreriaEntity> result  = service.getAll();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<LibreriaEntity>> getByName(@RequestParam String name){
        List <LibreriaEntity> result  = service.getByName(name);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LibreriaEntity> getById(@RequestParam int id){
        LibreriaEntity result = service.getById(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping()
    public ResponseEntity<LibreriaEntity> insert(@RequestBody LibreriaEntity body){
        LibreriaEntity result = service.insertOrUpdate(body);
        return ResponseEntity.ok(result);
    }




}
