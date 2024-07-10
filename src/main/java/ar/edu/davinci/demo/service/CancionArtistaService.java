package ar.edu.davinci.demo.service;

import ar.edu.davinci.demo.repository.CancionArtistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CancionArtistaService {

    @Autowired
    private CancionArtistaRepository cancionArtistaRepository;


}