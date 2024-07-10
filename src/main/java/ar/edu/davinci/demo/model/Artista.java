package ar.edu.davinci.demo.model;

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
            name = "artista_disco",
            joinColumns = @JoinColumn(name = "artista_id"),
            inverseJoinColumns = @JoinColumn(name = "disco_id")
    )
    private List<Disco> discos;

    @OneToMany(mappedBy = "artista", cascade = CascadeType.ALL)
    private List<CancionArtista> cancionesArtista;

    /*@OneToMany(mappedBy = "artista", cascade = CascadeType.ALL)
    private List<Disco> discos;*/

    /*@ManyToMany(mappedBy = "artistas")
    private List<Cancion> canciones;*/

    @ManyToMany
    @JoinTable(
            name = "artista_cancion",
            joinColumns = @JoinColumn(name = "artista_id"),
            inverseJoinColumns = @JoinColumn(name = "cancion_id")
    )
    private List<Cancion> canciones;

    // Constructor, getters y setters

    public Artista(){

    }

    public Artista(String nombre, Genero genero, Pais paisOrigen, Instrumento instrumento, Date fechaNacimiento, Date fechaFallecimiento, String biografia, List<Disco> discos, List<CancionArtista> cancionesArtista) {
        this.nombre = nombre;
        this.genero = genero;
        this.paisOrigen = paisOrigen;
        this.instrumento = instrumento;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaFallecimiento = fechaFallecimiento;
        this.biografia = biografia;
        this.discos = discos;
        this.cancionesArtista = cancionesArtista;
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

    public List<Disco> getDiscos() {
        return discos;
    }

    public void setDiscos(List<Disco> discos) {
        this.discos = discos;
    }

    public List<CancionArtista> getCancionesArtista() {
        return cancionesArtista;
    }

    public void setCancionesArtista(List<CancionArtista> cancionesArtista) {
        this.cancionesArtista = cancionesArtista;
    }

    public List<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(List<Cancion> canciones) {
        this.canciones = canciones;
    }
}
