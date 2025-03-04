package org.unir.examen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.unir.examen.model.Aula;
import org.unir.examen.service.AulaService;

import java.util.List;

@RestController
@RequestMapping("/aula")
public class AulaController {
    @Autowired
    private AulaService service;


    @GetMapping("")
    public ResponseEntity<List<Aula>> getAll(){
        List <Aula> result  = service.getAll();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/capacidad")
    public ResponseEntity<List<Aula>> getByCapacidad(){
        List <Aula> result  = service.getByCapacidad();
        return ResponseEntity.ok(result);
    }

}
