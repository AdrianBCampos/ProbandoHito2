package ar.edu.davinci.demo.model.DTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DiscoDTO {

    private String nombre;
    private String genero;
    private Date fechaLanzamiento;
    private List<Long> cancionesIds = new ArrayList<>();
    private List<Long> artistasIds = new ArrayList<>();

    // Getters y setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(Date fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public List<Long> getCancionesIds() {
        return cancionesIds;
    }

    public void setCancionesIds(List<Long> cancionesIds) {
        this.cancionesIds = cancionesIds;
    }

    public List<Long> getArtistasIds() {
        return artistasIds;
    }

    public void setArtistasIds(List<Long> artistasIds) {
        this.artistasIds = artistasIds;
    }
}
