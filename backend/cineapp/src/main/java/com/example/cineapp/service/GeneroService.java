package com.example.cineapp.service;

import com.example.cineapp.model.Genero;
import com.example.cineapp.repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class GeneroService {

    @Autowired
    private GeneroRepository generoRepository;

    public List<Genero> findAll() {
        return generoRepository.findAll();
    }

    public Optional<Genero> findById(Long id) {
        return generoRepository.findById(id);
    }

    public Genero save(Genero genero) {
        return generoRepository.save(genero);
    }

    public void deleteById(Long id) {
        generoRepository.deleteById(id);
    }
}