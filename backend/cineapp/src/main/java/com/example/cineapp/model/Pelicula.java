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

    public void setId(Long id){
        this.id = id;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public void setAnio(int anio){
        this.anio = anio;
    }

    public void setDirector(String director){
        this.director = director;
    }

    public void setSinopsis( String sinopsis){
        this.sinopsis = sinopsis;
    }

    public void setGenero(Genero genero){
        this.genero = genero;
    }

    public Long getId(){
        return id;
    }

    public String getTitulo(){
        return titulo;
    }

    public int getAnio(){
        return anio;
    }

    public String getDirector(){
        return director;
    }

    public String getSinopsis(){
        return sinopsis;
    }

    public Genero getGenero(){
        return genero;
    }
}