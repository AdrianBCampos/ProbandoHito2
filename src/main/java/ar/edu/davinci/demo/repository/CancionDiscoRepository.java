package ar.edu.davinci.demo.repository;

import ar.edu.davinci.demo.model.CancionDisco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CancionDiscoRepository extends JpaRepository<CancionDisco, Long> {

}