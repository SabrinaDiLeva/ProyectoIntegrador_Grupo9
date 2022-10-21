package com.controller;

import com.model.Categoria;
import com.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<Categoria> guardar(@RequestBody Categoria categoria) {
        try{
            return ResponseEntity.ok( categoriaService.guardar(categoria));
        } catch (Exception e ) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Categoria>>  listar() {
        return ResponseEntity.ok(categoriaService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> buscar(@PathVariable Long id) {
        Optional<Categoria> categoria = categoriaService.buscar(id);
        if (categoria.isPresent()) {
            return ResponseEntity.ok(categoria.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        try {
            categoriaService.eliminar(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity<Categoria> modificar(@RequestBody Categoria categoria) {
        try {
            return ResponseEntity.ok( categoriaService.modificar(categoria));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
