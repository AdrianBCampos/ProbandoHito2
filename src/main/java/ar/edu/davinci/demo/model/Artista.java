package ar.edu.davinci.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "artistas")
public class Artista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Enumerated(EnumType.STRING)
    private Genero genero;

    @Enumerated(EnumType.STRING)
    private Pais paisOrigen;

    @Enumerated (EnumType.STRING)
    private Instrumento instrumento;

    private Date fechaNacimiento;

    private Date fechaFallecimiento;

    @Lob
    private String biografia;


    @ManyToMany
    @JoinTable(
            name = "artistas_discos",
            joinColumns = @JoinColumn(name = "artista_id"),
            inverseJoinColumns = @JoinColumn(name = "disco_id")
    )
    private List<Disco> discosIds;


    @OneToMany(mappedBy = "artista", cascade = CascadeType.ALL)
    private List<CancionArtista> cancionesIds;

    /*@OneToMany(mappedBy = "artista", cascade = CascadeType.ALL)
    private List<Disco> discos;*/

    /*@ManyToMany(mappedBy = "artistas")
    private List<Cancion> canciones;*/

    /*@ManyToMany
    @JoinTable(
            name = "artista_cancion",
            joinColumns = @JoinColumn(name = "artista_id"),
            inverseJoinColumns = @JoinColumn(name = "cancion_id")
    )
    private List<Cancion> canciones;*/

    // Constructor, getters y setters

    public Artista(){

    }

    public Artista(String nombre, Genero genero, Pais paisOrigen, Instrumento instrumento, Date fechaNacimiento, Date fechaFallecimiento, String biografia, List<Disco> discosIds, List<CancionArtista> cancionesIds) {
        this.nombre = nombre;
        this.genero = genero;
        this.paisOrigen = paisOrigen;
        this.instrumento = instrumento;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaFallecimiento = fechaFallecimiento;
        this.biografia = biografia;
        this.discosIds = discosIds;
        this.cancionesIds = cancionesIds;
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

    public Pais getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(Pais paisOrigen) {
        this.paisOrigen = paisOrigen;
    }

    public Instrumento getInstrumento() {
        return instrumento;
    }

    public void setInstrumento(Instrumento instrumento) {
        this.instrumento = instrumento;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Date getFechaFallecimiento() {
        return fechaFallecimiento;
    }

    public void setFechaFallecimiento(Date fechaFallecimiento) {
        this.fechaFallecimiento = fechaFallecimiento;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public List<Disco> getDiscosIds() {
        return discosIds;
    }

    public void setDiscosIds(List<Disco> discosIds) {
        this.discosIds = discosIds;
    }

    public List<CancionArtista> getCancionesIds() {
        return cancionesIds;
    }

    public void setCancionesIds(List<CancionArtista> cancionesIds) {
        this.cancionesIds = cancionesIds;
    }
}
