package com.example.cineapp.repository;

import com.example.cineapp.model.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {
    List<Pelicula> findByGeneroId(Long generoId);
}