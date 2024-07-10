package ar.edu.davinci.demo.model.DTO;


import java.util.Date;
import java.util.List;

public class ArtistaDTO {

    private String nombre;
    private String genero;
    private String paisOrigen;
    private Date fechaNacimiento;
    private Date fechaFallecimiento;
    private String biografia;
    private String instrumento;
    private List<Long> cancionesIds;
    private List<Long> discosIds;




    // Getters y setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



    public String getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
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



    public List<Long> getCancionesIds() {
        return cancionesIds;
    }

    public void setCancionesIds(List<Long> cancionesIds) {
        this.cancionesIds = cancionesIds;
    }

    public List<Long> getDiscosIds() {
        return discosIds;
    }

    public void setDiscosIds(List<Long> discosIds) {
        this.discosIds = discosIds;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getInstrumento() {
        return instrumento;
    }

    public void setInstrumento(String instrumento) {
        this.instrumento = instrumento;
    }
}
