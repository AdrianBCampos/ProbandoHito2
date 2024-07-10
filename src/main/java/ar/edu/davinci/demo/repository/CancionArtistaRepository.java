package ar.edu.davinci.demo.repository;

import ar.edu.davinci.demo.model.CancionArtista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CancionArtistaRepository extends JpaRepository<CancionArtista, Long> {

}