package com.example.Backend.controller;

import com.example.Backend.model.Imagen;
import com.example.Backend.service.ImagenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://grupo9c7front.s3-website.us-east-2.amazonaws.com"})
@RequestMapping("/imagen")
public class ImagenController {
    @Autowired
    private ImagenService imagenService;
/*
    @PostMapping
    public ResponseEntity<Imagen> guardar(@RequestBody ImagenDTO imagen) {
        return ResponseEntity.ok(imagenService.guardar(imagen));
    }
*/
    @GetMapping
    public ResponseEntity<List<Imagen>>  listar() {
        return ResponseEntity.ok(imagenService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Imagen> buscar(@PathVariable Long id) {
        Imagen imagen = imagenService.buscar(id);
        return ResponseEntity.ok(imagen);
    }
/*
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
            imagenService.eliminar(id);
            return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Imagen> modificar(@PathVariable(name = "id") Long id , @RequestBody ImagenDTO imagen) {
        return ResponseEntity.ok(imagenService.modificar(id, imagen));
    }
*/
    @GetMapping("/producto/{id}")
    public ResponseEntity<List<Imagen>>  listarPorProducto(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(imagenService.listarPorProducto(id));
    }
}
