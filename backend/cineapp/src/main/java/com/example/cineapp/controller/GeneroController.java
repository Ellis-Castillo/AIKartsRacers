package com.example.cineapp.controller;

import com.example.cineapp.model.Genero;
import com.example.cineapp.service.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/generos")
@CrossOrigin(origins = "http://localhost:4200")
public class GeneroController {

    @Autowired
    private GeneroService generoService;

    @GetMapping
    public List<Genero> getAll() {
        return generoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Genero> getById(@PathVariable Long id) {
        return generoService.findById(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
}

    @PostMapping
    public Genero create(@RequestBody Genero genero) {
        return generoService.save(genero);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        generoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}