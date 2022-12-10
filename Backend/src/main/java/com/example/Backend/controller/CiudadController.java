package com.example.Backend.controller;

import com.example.Backend.dto.command.CiudadDTO;
import com.example.Backend.model.Ciudad;
import com.example.Backend.service.CiudadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://grupo9c7front.s3-website.us-east-2.amazonaws.com"})
@RequestMapping("/ciudad")
public class CiudadController {
    @Autowired
    private CiudadService ciudadService;

    @PostMapping
    public ResponseEntity<Ciudad> guardar(@RequestBody CiudadDTO ciudad) {
        return ResponseEntity.ok(ciudadService.guardar(ciudad));
    }

    @GetMapping
    public ResponseEntity<List<Ciudad>>  listar() {
        return ResponseEntity.ok(ciudadService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ciudad> buscar(@PathVariable Long id) {
        Ciudad ciudad = ciudadService.buscar(id);
            return ResponseEntity.ok(ciudad);
        }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        //Ciudad ciudadBuscada = ciudadService.buscar(id);
        ciudadService.eliminar(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ciudad> modificar(@PathVariable(name = "id")Long id, @RequestBody CiudadDTO ciudad) {
        return ResponseEntity.ok(ciudadService.modificar(id, ciudad));
    }
}
