package ar.edu.davinci.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "cancion_artista")
public class CancionArtista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "cancion_id")
    private Cancion cancion;


    @ManyToOne
    @JoinColumn(name = "artista_id")
    private Artista artista;

    // Getters y setters
    // Constructor vacío y con parámetros

    public CancionArtista() {
    }

    public CancionArtista(Cancion cancion, Artista artista) {
        this.cancion = cancion;
        this.artista = artista;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cancion getCancion() {
        return cancion;
    }

    public void setCancion(Cancion cancion) {
        this.cancion = cancion;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }
}
