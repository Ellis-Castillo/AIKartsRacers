package com.example.cineapp.service;

import com.example.cineapp.model.Pelicula;
import com.example.cineapp.repository.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PeliculaService {

    @Autowired
    private PeliculaRepository peliculaRepository;

    public List<Pelicula> findAll() {
        return peliculaRepository.findAll();
    }

    public Optional<Pelicula> findById(Long id) {
        return peliculaRepository.findById(id);
    }

    public List<Pelicula> findByGeneroId(Long generoId) {
        return peliculaRepository.findByGeneroId(generoId);
    }

    public Pelicula save(Pelicula pelicula) {
        return peliculaRepository.save(pelicula);
    }

    public void deleteById(Long id) {
        peliculaRepository.deleteById(id);
    }
}