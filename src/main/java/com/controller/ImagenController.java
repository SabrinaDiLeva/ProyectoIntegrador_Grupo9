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
        Optional<Imagen> imagen = imagenService.buscar(id);
        if (imagen.isPresent()) {
            return ResponseEntity.ok(imagen.get());
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        Optional<Imagen> imagenBuscada=imagenService.buscar(id);
        if (imagenBuscada.isPresent()){
            imagenService.eliminar(id);
            return ResponseEntity.ok("Se eliminó la imagen con id=" +id+ " de la base de datos");
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Imagen> modificar(@PathVariable(name = "id") Long id , @RequestBody Imagen imagen) {
        Optional<Imagen> imagenBuscada= imagenService.buscar(imagen.getId());
        if (imagenBuscada.isPresent()){
            return ResponseEntity.ok(imagenService.modificar(id, imagen));
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
