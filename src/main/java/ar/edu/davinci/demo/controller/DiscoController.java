package ar.edu.davinci.demo.controller;

import ar.edu.davinci.demo.model.Disco;
import ar.edu.davinci.demo.model.DTO.DiscoDTO;
import ar.edu.davinci.demo.model.Genero;
import ar.edu.davinci.demo.service.DiscoService;
import ar.edu.davinci.demo.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/discos")
public class DiscoController {

    @Autowired
    private DiscoService discoService;

    @GetMapping
    public List<Disco> buscarTodosLosDiscos() {
        return discoService.buscarTodosLosDiscos();
    }

    @PostMapping
    public ResponseEntity<Object> crearDisco(@RequestBody DiscoDTO discoDTO) {
        try {
            Disco discoGuardado = discoService.crearDisco(discoDTO);
            return ResponseEntity.ok(discoGuardado);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/{id}")
    public Disco buscarDiscoPorId(@PathVariable Long id) {
        return discoService.buscarDiscoPorId(id).orElseThrow(() -> new ResourceNotFoundException("Disco con id " + id + " no encontrado."));
    }

    @GetMapping("/buscarPorNombre")
    public ResponseEntity<List<Disco>> buscarDiscosPorNombre(@RequestParam String nombre) {
        List<Disco> discos = discoService.buscarDiscosPorNombre(nombre);
        return ResponseEntity.ok(discos);
    }

    @GetMapping("/buscarPorGenero")
    public ResponseEntity<List<Disco>> buscarDiscosPorGenero(@RequestParam Genero genero) {
        List<Disco> discos = discoService.buscarDiscosPorGenero(genero);
        return ResponseEntity.ok(discos);
    }

    @GetMapping("/buscarPorFechaLanzamiento")
    public ResponseEntity<List<Disco>> buscarDiscosPorFechaLanzamiento(@RequestParam String fechaLanzamiento) {
        List<Disco> discos = discoService.buscarDiscosPorFechaLanzamiento(fechaLanzamiento);
        return ResponseEntity.ok(discos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> modificarDisco(@PathVariable Long id, @RequestBody DiscoDTO discoDTO) {
        try {
            Disco discoActualizado = discoService.actualizarDisco(id, discoDTO);
            return ResponseEntity.ok(discoActualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarDisco(@PathVariable Long id) {
        Disco disco = discoService.buscarDiscoPorId(id)
                .orElseThrow(() -> new ResourceNotFoundException("Disco no encontrado con id " + id));
        discoService.eliminarDisco(disco);
        return ResponseEntity.ok("El disco \"" + disco.getNombre() + "\" fue eliminado.");
    }
}
