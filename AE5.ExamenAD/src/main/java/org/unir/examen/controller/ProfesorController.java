package org.unir.examen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.unir.examen.model.Profesor;
import org.unir.examen.service.ProfesorService;

import java.util.List;

@RestController
@RequestMapping("/profesor")
public class ProfesorController {


    @Autowired
    private ProfesorService service;


    @GetMapping("/by-curso")
    public ResponseEntity<List<Profesor>> getByName(@RequestParam int idCurso){
        List <Profesor> result  = service.getByCurso(idCurso);
        return ResponseEntity.ok(result);
    }



    @PostMapping()
    public ResponseEntity<Profesor> insertOrUpdate(@RequestBody Profesor body){
        Profesor result = service.insertOrUpdate(body);
        return ResponseEntity.ok(result);
    }

}
