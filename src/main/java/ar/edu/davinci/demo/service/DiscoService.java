package ar.edu.davinci.demo.service;

import ar.edu.davinci.demo.exception.ResourceNotFoundException;
import ar.edu.davinci.demo.model.Disco;
import ar.edu.davinci.demo.model.DTO.DiscoDTO;
import ar.edu.davinci.demo.model.Genero;
import ar.edu.davinci.demo.repository.DiscoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DiscoService {

    @Autowired
    private DiscoRepository discoRepository;

    public Disco crearDisco(DiscoDTO discoDTO) throws ParseException {
        try {
            Disco disco = new Disco();
            disco.setNombre(discoDTO.getNombre());
            disco.setGenero(Genero.valueOf(discoDTO.getGenero().toUpperCase()));

            String fechaLanzamientoStr = String.valueOf(discoDTO.getFechaLanzamiento());
            if (fechaLanzamientoStr != null && !fechaLanzamientoStr.isEmpty()) {
                disco.setFechaLanzamiento(discoDTO.getFechaLanzamiento());
            }
            return discoRepository.save(disco);
        } catch (DataAccessException e) {
            throw new RuntimeException("Error al acceder a la base de datos", e);
        }
    }

    public Optional<Disco> buscarDiscoPorId(Long id) {
        return discoRepository.findById(id);
    }

    public List<Disco> buscarTodosLosDiscos() {
        return discoRepository.findAll();
    }

    public List<Disco> buscarDiscosPorNombre(String nombre) {
        return discoRepository.findByNombreContainingIgnoreCase(nombre);
    }

    public List<Disco> buscarDiscosPorGenero(Genero genero) {
        return discoRepository.findByGenero(genero);
    }

    public List<Disco> buscarDiscosPorFechaLanzamiento(String fechaLanzamiento) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date fecha = formatter.parse(fechaLanzamiento);
            return discoRepository.findByFechaLanzamiento(fecha);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Formato de fecha incorrecto: " + e.getMessage());
        }
    }

    public Disco actualizarDisco(Long id, DiscoDTO discoDTO) throws ParseException {
        try {
            Disco disco = discoRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Disco con id " + id + " no encontrado."));

            if (discoDTO.getNombre() != null && !discoDTO.getNombre().isEmpty()) {
                disco.setNombre(discoDTO.getNombre());
            }

            if (discoDTO.getGenero() != null && !discoDTO.getGenero().isEmpty()) {
                disco.setGenero(Genero.valueOf(discoDTO.getGenero().toUpperCase()));
            }

            if (discoDTO.getFechaLanzamiento() != null) {
                disco.setFechaLanzamiento(discoDTO.getFechaLanzamiento());
            }

            return discoRepository.save(disco);
        } catch (DataAccessException e) {
            throw new RuntimeException("Error al acceder a la base de datos", e);
        }
    }

    public void eliminarDisco(Disco disco) {
        discoRepository.delete(disco);
    }
}
