package ar.edu.davinci.demo.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "discos")
public class Disco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Enumerated(EnumType.STRING)
    private Genero genero;

    private Date fechaLanzamiento;

    /*@ManyToMany(mappedBy = "disco", cascade = CascadeType.ALL)
    private List<Cancion> canciones;

    @ManyToMany(mappedBy = "discos")
    private List<Artista> artistas;*/

    @OneToMany(mappedBy = "disco", cascade = CascadeType.ALL)
    private List<CancionDisco> cancionesDisco;

    @ManyToMany
    @JoinTable(
            name = "artista_disco",
            joinColumns = @JoinColumn(name = "disco_id"),
            inverseJoinColumns = @JoinColumn(name = "artista_id")
    )
    private List<Artista> artistas;


    // Constructor, getters y setters

    public Disco(){

    }

    public Disco(String nombre, Genero genero, Date fechaLanzamiento, List<CancionDisco> cancionesDisco, List<Artista> artistas) {
        this.nombre = nombre;
        this.genero = genero;
        this.fechaLanzamiento = fechaLanzamiento;
        this.cancionesDisco = cancionesDisco;
        this.artistas = artistas;
    }

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

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Date getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(Date fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public List<CancionDisco> getCancionesDisco() {
        return cancionesDisco;
    }

    public void setCancionesDisco(List<CancionDisco> cancionesDisco) {
        this.cancionesDisco = cancionesDisco;
    }

    public List<Artista> getArtistas() {
        return artistas;
    }

    public void setArtistas(List<Artista> artistas) {
        this.artistas = artistas;
    }
}
