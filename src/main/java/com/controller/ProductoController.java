package com.controller;

import com.dto.command.ProductoDTO;
import com.model.Producto;
import com.service.ProductoService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/producto")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @PostMapping
    public ResponseEntity<Producto> guardar(@RequestBody ProductoDTO producto) {
        return ResponseEntity.ok(productoService.guardar(producto));
    }

    @GetMapping
    public ResponseEntity<List<Producto>>  listar() {
        return ResponseEntity.ok(productoService.listar());
    }

    @GetMapping("random")
    public ResponseEntity<List<Producto>>  listarRandom() {
        return ResponseEntity.ok(productoService.listarRandom());
    }

    @GetMapping("/categoria/{id}")
    public ResponseEntity<List<Producto>>  listarPorCategoria(@PathVariable Long id) {
        return ResponseEntity.ok(productoService.listarPorIdCategoria(id));
    }
    @GetMapping("/ciudad/{id}")
    public ResponseEntity<List<Producto>>  listarPorCiudad(@PathVariable Long id) {
        return ResponseEntity.ok(productoService.listarPorIdCiudad(id));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Producto> buscar(@PathVariable Long id) {
        Producto producto = productoService.buscar(id);
        return ResponseEntity.ok(producto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        productoService.eliminar(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> modificar(@PathVariable(name = "id") Long id, @RequestBody ProductoDTO producto) {
        return ResponseEntity.ok(productoService.modificar(id, producto));
    }
}
