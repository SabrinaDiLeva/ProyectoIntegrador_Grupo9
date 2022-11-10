package com.controller;

import com.dto.command.CiudadDTO;
import com.model.Ciudad;
import com.service.CiudadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ciudad")
public class CiudadController {
    @Autowired
    private CiudadService ciudadService;

    @PostMapping
    public ResponseEntity<Ciudad> guardar(@RequestBody CiudadDTO ciudad) {
        return ResponseEntity.ok(ciudadService.guardar(ciudad));
    }

    @CrossOrigin(origins = "http://localhost:3000")
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
