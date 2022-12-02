package com.example.Backend.controller;

import com.example.Backend.dto.command.ProductoDTO;
import com.example.Backend.model.Producto;
import com.example.Backend.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @PostMapping
    public ResponseEntity<Producto> guardar(@RequestBody ProductoDTO producto) {
        return ResponseEntity.ok(productoService.guardar(producto));
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public ResponseEntity<List<Producto>>  listar() {
        return ResponseEntity.ok(productoService.listar());
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/random")
    public ResponseEntity<List<Producto>>  listarRandom() {
        return ResponseEntity.ok(productoService.listarRandom());
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/categoria/{id}")
    public ResponseEntity<List<Producto>>  listarPorCategoria(@PathVariable Long id) {
        return ResponseEntity.ok(productoService.listarPorIdCategoria(id));
    }
    @GetMapping("/ciudad/{id}")
    public ResponseEntity<List<Producto>>  listarPorCiudad(@PathVariable Long id) {
        return ResponseEntity.ok(productoService.listarPorIdCiudad(id));
    }

    @GetMapping("/filtrar/{ciudad}/{inicio}/{fin}")
    public ResponseEntity<List<Producto>>  filtrarBusqueda(@PathVariable Long ciudad,@PathVariable String inicio, @PathVariable String fin) {
        LocalDate i = LocalDate.parse(inicio);
        LocalDate f = LocalDate.parse(fin);
        return ResponseEntity.ok(productoService.filtrarBusqueda(ciudad,i,f));
    }

    @CrossOrigin(origins = "http://localhost:3000")
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
