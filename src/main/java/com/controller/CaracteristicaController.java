package com.controller;

import com.model.Caracteristica;
import com.service.CaracteristicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/caracteristica")
public class CaracteristicaController {
    @Autowired
    private CaracteristicaService caracteristicaService;

    @PostMapping
    public ResponseEntity<Caracteristica> guardar(@RequestBody Caracteristica caracteristica) {
        return ResponseEntity.ok(caracteristicaService.guardar(caracteristica));
    }

    @GetMapping
    public ResponseEntity<List<Caracteristica>>  listar() {
        return ResponseEntity.ok(caracteristicaService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Caracteristica> buscar(@PathVariable Long id) {
        Optional<Caracteristica> caracteristica = caracteristicaService.buscar(id);
        if (caracteristica.isPresent()) {
            return ResponseEntity.ok(caracteristica.get());
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        Optional<Caracteristica> caracteristicaBuscada=caracteristicaService.buscar(id);
        if (caracteristicaBuscada.isPresent()){
            caracteristicaService.eliminar(id);
            return ResponseEntity.ok("Se eliminó la caracteristica  con id=" +id+ " de la base de datos");
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Caracteristica> modificar(@RequestBody Caracteristica caracteristica) {
        Optional<Caracteristica> caracteristicaBuscada= caracteristicaService.buscar(caracteristica.getId());
        if (caracteristicaBuscada.isPresent()){
            return ResponseEntity.ok(caracteristicaService.modificar(caracteristica));
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
