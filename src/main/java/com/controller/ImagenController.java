package com.controller;

import com.model.Imagen;
import com.service.ImagenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/imagen")
public class ImagenController {
    @Autowired
    private ImagenService imagenService;

    @PostMapping
    public ResponseEntity<Imagen> guardar(@RequestBody Imagen imagen) {
        return ResponseEntity.ok(imagenService.guardar(imagen));
    }

    @GetMapping
    public ResponseEntity<List<Imagen>>  listar() {
        return ResponseEntity.ok(imagenService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Imagen> buscar(@PathVariable Long id) {
        Imagen imagen = imagenService.buscar(id);
        return ResponseEntity.ok(imagen);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
            imagenService.eliminar(id);
            return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Imagen> modificar(@PathVariable(name = "id") Long id , @RequestBody Imagen imagen) {
        return ResponseEntity.ok(imagenService.modificar(id, imagen));
    }
}
