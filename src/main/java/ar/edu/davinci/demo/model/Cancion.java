package ar.edu.davinci.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "canciones")
public class Cancion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String letra;

    @Enumerated(EnumType.STRING)
    private Genero genero;


    @OneToMany(mappedBy = "cancion", cascade = CascadeType.ALL)
    private List<CancionArtista> cancionesArtista;


    @OneToMany(mappedBy = "cancion", cascade = CascadeType.ALL)
    private List<CancionDisco> cancionesDisco;



    /*@ManyToMany(mappedBy = "canciones")
    private List<Artista> artistas;

    @ManyToMany(mappedBy = "canciones")
    private List<Disco> discos;*/

    // Constructor, getters y setters
    // Constructor vacío y con parámetros

    public Cancion() {
    }

    public Cancion(String nombre, String letra, Genero genero, List<CancionArtista> cancionesArtista, List<CancionDisco> cancionesDisco) {
        this.nombre = nombre;
        this.letra = letra;
        this.genero = genero;
        this.cancionesArtista = cancionesArtista;
        this.cancionesDisco = cancionesDisco;
    }

    // Getters y setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public List<CancionArtista> getCancionesArtista() {
        return cancionesArtista;
    }

    public void setCancionesArtista(List<CancionArtista> cancionesArtista) {
        this.cancionesArtista = cancionesArtista;
    }

    public List<CancionDisco> getCancionesDisco() {
        return cancionesDisco;
    }

    public void setCancionesDisco(List<CancionDisco> cancionesDisco) {
        this.cancionesDisco = cancionesDisco;
    }
}

/* V1.0
package ar.edu.davinci.demo.model;


import jakarta.persistence.*;

@Entity
@Table(name = "canciones")
public class Cancion {
    @Id
    @GeneratedValue
    private long id;
    private String nombre;
    private String letra;
    @Enumerated(EnumType.STRING)
    private Genero genero;

    public Cancion(){

    }

    public Cancion(String nombre, String letra, Genero genero){
        this.nombre = nombre;
        this.letra = letra;
        this.genero = genero;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }
}*/
