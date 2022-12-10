package com.example.Backend.controller;

import com.example.Backend.dto.command.CategoriaDTO;
import com.example.Backend.model.Categoria;
import com.example.Backend.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://grupo9c7front.s3-website.us-east-2.amazonaws.com"})
@RequestMapping("/categoria")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<Categoria> guardar(@RequestBody CategoriaDTO categoria) {
        return ResponseEntity.ok(categoriaService.guardar(categoria));
    }

    @GetMapping
    public ResponseEntity<List<Categoria>>  listar() {
        return ResponseEntity.ok(categoriaService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> buscar(@PathVariable Long id) {
        Categoria categoria = categoriaService.buscar(id);
        return ResponseEntity.ok(categoria);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        categoriaService.eliminar(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> modificar(@PathVariable( name = "id") Long id, @RequestBody CategoriaDTO categoria) {
        return ResponseEntity.ok(categoriaService.modificar(id, categoria));
    }
}

