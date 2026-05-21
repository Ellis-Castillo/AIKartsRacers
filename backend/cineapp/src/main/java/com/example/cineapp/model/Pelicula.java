package com.example.cineapp.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "peliculas")
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private int anio;

    private String director;

    private String sinopsis;

    @ManyToOne
    @JoinColumn(name = "genero_id")
    private Genero genero;

    public void setId(){}

    public void setTitulo(){}

    public void setDirector(){}

    public void setSinopsis(){}

    public void setAnio(){}
}