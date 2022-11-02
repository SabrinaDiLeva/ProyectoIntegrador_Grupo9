package com.controller;

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
    public ResponseEntity<Ciudad> guardar(@RequestBody Ciudad ciudad) {
        return ResponseEntity.ok(ciudadService.guardar(ciudad));
    }

    @GetMapping
    public ResponseEntity<List<Ciudad>>  listar() {
        return ResponseEntity.ok(ciudadService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ciudad> buscar(@PathVariable Long id) {
        Optional<Ciudad> ciudad = ciudadService.buscar(id);
        if (ciudad.isPresent()) {
            return ResponseEntity.ok(ciudad.get());
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        Optional<Ciudad> ciudadBuscada=ciudadService.buscar(id);
        if (ciudadBuscada.isPresent()){
            ciudadService.eliminar(id);
            return ResponseEntity.ok("Se eliminó la ciudad  con id=" +id+ " de la base de datos");
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ciudad> modificar(@RequestBody Ciudad ciudad) {
        Optional<Ciudad> ciudadBuscada= ciudadService.buscar(ciudad.getId());
        if (ciudadBuscada.isPresent()){
            return ResponseEntity.ok(ciudadService.modificar(ciudad));
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
