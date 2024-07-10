package ar.edu.davinci.demo.controller;

import ar.edu.davinci.demo.service.CancionDiscoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cancionDisco")
public class CancionDiscoController {

    @Autowired
    private CancionDiscoService cancionDiscoService;


}