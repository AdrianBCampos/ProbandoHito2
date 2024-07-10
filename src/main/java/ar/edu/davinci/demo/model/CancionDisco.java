package ar.edu.davinci.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cancion_disco")
public class CancionDisco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cancion_id")
    private Cancion cancion;

    @ManyToOne
    @JoinColumn(name = "disco_id")
    private Disco disco;

    // Getters y setters
    // Constructor vacío y con parámetros

    public CancionDisco() {
    }

    public CancionDisco(Cancion cancion, Disco disco) {
        this.cancion = cancion;
        this.disco = disco;
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

    public Disco getDisco() {
        return disco;
    }

    public void setDisco(Disco disco) {
        this.disco = disco;
    }
}
