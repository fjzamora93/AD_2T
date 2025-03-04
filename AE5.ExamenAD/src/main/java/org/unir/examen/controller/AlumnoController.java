package org.unir.examen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.unir.examen.model.Alumno;
import org.unir.examen.service.AlumnoService;

import java.util.List;

@RestController
@RequestMapping("/alumno")
public class AlumnoController {

    @Autowired
    private AlumnoService service;

    @GetMapping("")
    public ResponseEntity<List<Alumno>> getAll(){
        List <Alumno> result  = service.getAll();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/by-curso")
    public ResponseEntity<List<Alumno>> getByCurso(@RequestParam int cursoId){
        List <Alumno> result  = service.getByCurso(cursoId);
        return ResponseEntity.ok(result);
    }

    @PostMapping()
    public ResponseEntity<Alumno> insertOrUpdate(@RequestBody Alumno body){
        Alumno result = service.insertOrUpdate(body);
        return ResponseEntity.ok(result);
    }


}
