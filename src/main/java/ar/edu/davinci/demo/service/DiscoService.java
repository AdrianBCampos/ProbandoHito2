package ar.edu.davinci.demo.service;

import ar.edu.davinci.demo.exception.ResourceNotFoundException;
import ar.edu.davinci.demo.model.*;
import ar.edu.davinci.demo.model.DTO.DiscoDTO;
import ar.edu.davinci.demo.repository.ArtistaRepository;
import ar.edu.davinci.demo.repository.CancionRepository;
import ar.edu.davinci.demo.repository.DiscoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DiscoService {

    private final DiscoRepository discoRepository;
    private final CancionRepository cancionRepository;
    private final ArtistaRepository artistaRepository;

    @Autowired
    public DiscoService(DiscoRepository discoRepository, CancionRepository cancionRepository, ArtistaRepository artistaRepository) {
        this.discoRepository = discoRepository;
        this.cancionRepository = cancionRepository;
        this.artistaRepository = artistaRepository;
    }

    @Transactional
    public Disco crearDisco(Disco nuevoDisco, List<Long> cancionesIds, List<Long> artistasIds) {
        // Asociar canciones al disco
        List<Cancion> canciones = cancionesIds.stream()
                .map(id -> cancionRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Canción no encontrada con id: " + id)))
                .collect(Collectors.toList());

        canciones.forEach(cancion -> nuevoDisco.getCancionesDisco().add(new CancionDisco(cancion, nuevoDisco)));

        // Asociar artistas al disco
        List<Artista> artistas = artistasIds.stream()
                .map(id -> artistaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Artista no encontrado con id: " + id)))
                .collect(Collectors.toList());

        artistas.forEach(artista -> nuevoDisco.getArtistas().add(artista));

        // Guardar el disco en la base de datos
        return discoRepository.save(nuevoDisco);
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
