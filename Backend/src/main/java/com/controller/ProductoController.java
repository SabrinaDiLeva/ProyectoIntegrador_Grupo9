package com.controller;

import com.dto.command.ProductoDTO;
import com.model.Producto;
import com.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://grupo9c7front.s3-website.us-east-2.amazonaws.com"})
@RequestMapping("/producto")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @PostMapping
    public ResponseEntity<Producto> guardar(@RequestBody ProductoDTO producto) {
        return ResponseEntity.ok(productoService.guardar(producto));
    }

    // @CrossOrigin(origins = "http://grupo9c7front.s3-website.us-east-2.amazonaws.com")
    @GetMapping
    public ResponseEntity<List<Producto>>  listar() {
        return ResponseEntity.ok(productoService.listar());
    }

    // @CrossOrigin(origins = "http://grupo9c7front.s3-website.us-east-2.amazonaws.com")
    @GetMapping("/random")
    public ResponseEntity<List<Producto>>  listarRandom() {
        return ResponseEntity.ok(productoService.listarRandom());
    }

    // @CrossOrigin(origins = "http://grupo9c7front.s3-website.us-east-2.amazonaws.com")
    @GetMapping("/categoria/{id}")
    public ResponseEntity<List<Producto>>  listarPorCategoria(@PathVariable Long id) {
        return ResponseEntity.ok(productoService.listarPorIdCategoria(id));
    }
    @GetMapping("/ciudad/{id}")
    public ResponseEntity<List<Producto>>  listarPorCiudad(@PathVariable Long id) {
        return ResponseEntity.ok(productoService.listarPorIdCiudad(id));
    }
    // @CrossOrigin(origins = "http://grupo9c7front.s3-website.us-east-2.amazonaws.com")
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
