package ar.edu.davinci.demo.controller;

import ar.edu.davinci.demo.service.CancionArtistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cancionArtista")
public class CancionArtistaController {

    @Autowired
    private CancionArtistaService cancionArtistaService;


}