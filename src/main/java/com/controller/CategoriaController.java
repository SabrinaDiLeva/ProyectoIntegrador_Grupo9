package com.controller;

import com.model.Categoria;
import com.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
        return ResponseEntity.ok(categoriaService.guardar(categoria));
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
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        Optional<Categoria> categoriaBuscada=categoriaService.buscar(id);
        if (categoriaBuscada.isPresent()){
            categoriaService.eliminar(id);
            return ResponseEntity.ok("Se eliminó la categoria  con id=" +id+ " de la base de datos");
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> modificar(@RequestBody Categoria categoria) {
        Optional<Categoria> categoriaBuscada= categoriaService.buscar(categoria.getId());
        if (categoriaBuscada.isPresent()){
            return ResponseEntity.ok(categoriaService.modificar(categoria));
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
