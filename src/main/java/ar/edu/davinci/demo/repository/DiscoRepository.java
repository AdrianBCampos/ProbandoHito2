package ar.edu.davinci.demo.repository;

import ar.edu.davinci.demo.model.Disco;
import ar.edu.davinci.demo.model.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface DiscoRepository extends JpaRepository<Disco, Long> {

    List<Disco> findByNombreContainingIgnoreCase(String nombre);

    List<Disco> findByGenero(Genero genero);

    List<Disco> findByFechaLanzamiento(Date fechaLanzamiento);
}
