package ar.edu.davinci.demo.service;

import ar.edu.davinci.demo.repository.CancionDiscoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CancionDiscoService {

    @Autowired
    private CancionDiscoRepository cancionDiscoRepository;

    // Métodos para operaciones CRUD y lógica de negocio adicional
}