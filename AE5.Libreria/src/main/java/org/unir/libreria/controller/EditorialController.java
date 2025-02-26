package org.unir.libreria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.unir.libreria.model.Editorial;
import org.unir.libreria.service.EditorialService;

import java.util.List;

@RestController
@RequestMapping("/editorial")
public class EditorialController {

    @Autowired
    private EditorialService service;

    @GetMapping("")
    public ResponseEntity<List<Editorial>> getAll(){
        List <Editorial> result  = service.getAll();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<Editorial>> getByName(@RequestParam String name){
        List <Editorial> result  = service.getByName(name);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Editorial> getById(@PathVariable int id){
        Editorial result = service.getById(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping()
    public ResponseEntity<Editorial> insert(@RequestBody Editorial body){
        Editorial result = service.save(body);
        return ResponseEntity.ok(result);
    }


}
