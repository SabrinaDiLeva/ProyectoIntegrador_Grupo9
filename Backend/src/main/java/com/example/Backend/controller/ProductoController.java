package com.example.Backend.controller;

import com.example.Backend.dto.command.ProductoDTO;
import com.example.Backend.model.Producto;
import com.example.Backend.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.time.LocalDate;

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

    @GetMapping
    public ResponseEntity<List<Producto>>  listar() {
        return ResponseEntity.ok(productoService.listar());
    }

    @GetMapping("/random")
    public ResponseEntity<List<Producto>>  listarRandom() {
        return ResponseEntity.ok(productoService.listarRandom());
    }

    @GetMapping("/categoria/{titulo}")
    public ResponseEntity<List<Producto>>  listarPorCategoria(@PathVariable String titulo) {
        return ResponseEntity.ok(productoService.listarPorCategoria(titulo));
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
