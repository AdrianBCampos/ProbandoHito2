package ar.edu.davinci.demo.repository;

import ar.edu.davinci.demo.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArtistaRepository extends JpaRepository<Artista, Long> {

    List<Artista> findByGenero(Genero genero);

    List<Artista> findByPaisOrigen(Pais paisOrigen);


    @Query("SELECT a FROM Artista a WHERE a.instrumento = :instrumento")
    List<Artista> findByInstrumento(@Param("instrumento") Instrumento instrumento);

    List<Artista> findByFechaFallecimientoIsNull();

    List<Artista> findByFechaFallecimientoIsNotNull();

    @Query("SELECT a FROM Artista a WHERE SIZE(a.canciones) = :size")
    List<Artista> findByCancionesSize(@Param("size") int size);

    // Otras consultas según las necesidades adicionales
}
