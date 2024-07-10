package ar.edu.davinci.demo.controller;

import ar.edu.davinci.demo.model.Artista;
import ar.edu.davinci.demo.model.DTO.ArtistaDTO;

import ar.edu.davinci.demo.model.Genero;
import ar.edu.davinci.demo.model.Instrumento;
import ar.edu.davinci.demo.model.Pais;
import ar.edu.davinci.demo.service.ArtistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artistas")
public class ArtistaController {

    @Autowired
    private ArtistaService artistaService;

    @PostMapping
    public ResponseEntity<Object> crearArtista(@RequestBody ArtistaDTO artistaDTO) {
        try {
            Artista artistaGuardado = artistaService.crearArtista(artistaDTO);
            return ResponseEntity.ok(artistaGuardado);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public Artista buscarArtistaPorId(@PathVariable Long id) {
        return artistaService.buscarArtistaPorId(id);
    }

    @GetMapping("/porGenero")
    public List<Artista> buscarArtistasPorGenero(@RequestParam Genero genero) {
        return artistaService.buscarArtistasPorGenero(genero);
    }

    @GetMapping("/porPaisOrigen")
    public List<Artista> buscarArtistasPorPaisOrigen(@RequestParam Pais paisOrigen) {
        return artistaService.buscarArtistasPorPaisOrigen(paisOrigen);
    }

    @GetMapping("/por-instrumento/{instrumento}")
    public List<Artista> buscarPorInstrumento(@PathVariable Instrumento instrumento) {
        return artistaService.buscarPorInstrumento(instrumento);
    }

    @GetMapping("/vivos")
    public List<Artista> buscarArtistasVivos() {
        return artistaService.buscarArtistasVivos();
    }

    @GetMapping("/fallecidos")
    public List<Artista> buscarArtistasFallecidos() {
        return artistaService.buscarArtistasFallecidos();
    }

    @GetMapping("/porCantidadCanciones")
    public List<Artista> buscarArtistasPorCantidadCanciones(@RequestParam int cantidadCanciones) {
        return artistaService.buscarArtistasPorCantidadCanciones(cantidadCanciones);
    }

    @GetMapping
    public List<Artista> buscarTodosLosArtistas() {
        return artistaService.buscarTodosLosArtistas();
    }
}

