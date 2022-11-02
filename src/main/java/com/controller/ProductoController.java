package com.controller;

import com.model.Producto;
import com.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/producto")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @PostMapping
    public ResponseEntity<Producto> guardar(@RequestBody Producto producto) {
        return ResponseEntity.ok(productoService.guardar(producto));
    }

    @GetMapping
    public ResponseEntity<List<Producto>>  listar() {
        return ResponseEntity.ok(productoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> buscar(@PathVariable Long id) {
        Optional<Producto> producto = productoService.buscar(id);
        if (producto.isPresent()) {
            return ResponseEntity.ok(producto.get());
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        Optional<Producto> productoBuscada=productoService.buscar(id);
        if (productoBuscada.isPresent()){
            productoService.eliminar(id);
            return ResponseEntity.ok("Se eliminó el producto con id=" +id+ " de la base de datos");
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> modificar(@RequestBody Producto producto) {
        Optional<Producto> productoBuscado= productoService.buscar(producto.getId());
        if (productoBuscado.isPresent()){
            return ResponseEntity.ok(productoService.modificar(producto));
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
