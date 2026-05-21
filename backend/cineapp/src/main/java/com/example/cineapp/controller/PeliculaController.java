package com.example.cineapp.controller;

import com.example.cineapp.model.Pelicula;
import com.example.cineapp.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/peliculas")
@CrossOrigin(origins = "http://localhost:4200")
public class PeliculaController {

    @Autowired
    private PeliculaService peliculaService;

    @GetMapping
    public List<Pelicula> getAll() {
        return peliculaService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Pelicula> getById(@PathVariable Long id) {
        return peliculaService.findById(id);
    }

    @GetMapping("/generos/{generoId}")
    public List<Pelicula> getByGenero(@PathVariable Long generoId) {
        return peliculaService.findByGeneroId(generoId);
    }

    @PostMapping
    public Pelicula create(@RequestBody Pelicula pelicula) {
        return peliculaService.save(pelicula);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        peliculaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}