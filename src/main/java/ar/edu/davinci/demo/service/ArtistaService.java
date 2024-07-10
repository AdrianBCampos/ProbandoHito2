package ar.edu.davinci.demo.service;

import ar.edu.davinci.demo.exception.ResourceNotFoundException;
import ar.edu.davinci.demo.model.*;
import ar.edu.davinci.demo.model.DTO.ArtistaDTO;
import ar.edu.davinci.demo.repository.ArtistaRepository;
import ar.edu.davinci.demo.repository.CancionRepository;
import ar.edu.davinci.demo.repository.DiscoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ArtistaService {

    private final ArtistaRepository artistaRepository;
    private final DiscoRepository discoRepository;
    private final CancionRepository cancionRepository;

    @Autowired
    public ArtistaService(ArtistaRepository artistaRepository, DiscoRepository discoRepository, CancionRepository cancionRepository) {
        this.artistaRepository = artistaRepository;
        this.discoRepository = discoRepository;
        this.cancionRepository = cancionRepository;
    }


    @Transactional
    public Artista crearArtista(ArtistaDTO artistaDTO) {
        try {
            Artista artista = new Artista();
            artista.setNombre(artistaDTO.getNombre());
            artista.setGenero(Genero.valueOf(artistaDTO.getGenero()));
            artista.setPaisOrigen(Pais.valueOf(artistaDTO.getPaisOrigen()));
            artista.setInstrumento(Instrumento.valueOf(artistaDTO.getInstrumento()));
            artista.setFechaNacimiento(artistaDTO.getFechaNacimiento());
            artista.setFechaFallecimiento(artistaDTO.getFechaFallecimiento());
            artista.setBiografia(artistaDTO.getBiografia());



            // Asignar discos al artista (a través de sus IDs)
            if (artistaDTO.getDiscosIds() != null) {
                List<Disco> discos = artistaDTO.getDiscosIds().stream()
                        .map(discoRepository::findById)
                        .map(optionalDisco -> optionalDisco.orElseThrow(() -> new ResourceNotFoundException("Disco no encontrado")))
                        .collect(Collectors.toList());
                artista.setDiscos(discos);
            }

            // Asignar canciones al artista (a través de sus IDs)
            if (artistaDTO.getCancionesIds() != null) {
                List<Cancion> canciones = artistaDTO.getCancionesIds().stream()
                        .map(cancionRepository::findById)
                        .map(optionalCancion -> optionalCancion.orElseThrow(() -> new ResourceNotFoundException("Cancion no encontrada")))
                        .collect(Collectors.toList());
                artista.setCanciones(canciones);
            }

            return artistaRepository.save(artista);

        } catch (DataAccessException e) {
            throw new RuntimeException("Error al acceder a la base de datos", e);
        }
    }




    public Artista buscarArtistaPorId(Long id) {
        return artistaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Artista no encontrado con id " + id));
    }

    public List<Artista> buscarArtistasPorGenero(Genero genero) {
        return artistaRepository.findByGenero(genero);
    }

    public List<Artista> buscarArtistasPorPaisOrigen(Pais paisOrigen) {
        return artistaRepository.findByPaisOrigen(paisOrigen);
    }

    public List<Artista> buscarPorInstrumento(Instrumento instrumento) {
        return artistaRepository.findByInstrumento(instrumento);
    }

    public List<Artista> buscarArtistasVivos() {
        return artistaRepository.findByFechaFallecimientoIsNull();
    }

    public List<Artista> buscarArtistasFallecidos() {
        return artistaRepository.findByFechaFallecimientoIsNotNull();
    }

    public List<Artista> buscarArtistasPorCantidadCanciones(int cantidadCanciones) {
        return artistaRepository.findByCancionesSize(cantidadCanciones);
    }

    public List<Artista> buscarTodosLosArtistas() {
        return artistaRepository.findAll();
    }
}

