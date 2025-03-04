package org.unir.examen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.unir.examen.model.Curso;
import org.unir.examen.service.CursoService;

import java.util.List;

@RestController
@RequestMapping("/curso")
public class CursoController {
    @Autowired private CursoService service;


    @GetMapping("/by-profesor")
    public ResponseEntity<List<Curso>> getByProfesor(@RequestParam int id){
        List <Curso> result  = service.getCursosByProfesor(id);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/by-aula")
    public ResponseEntity<Curso> getByAula(@RequestParam int id){
        Curso result  = service.getCursoByAula(id);
        return ResponseEntity.ok(result);
    }




}
