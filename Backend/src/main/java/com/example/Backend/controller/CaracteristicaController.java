package com.example.Backend.controller;

import com.example.Backend.dto.command.CaracteristicaDTO;
import com.example.Backend.model.Caracteristica;
import com.example.Backend.service.CaracteristicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://grupo9c7front.s3-website.us-east-2.amazonaws.com"})
@RequestMapping("/caracteristica")
public class CaracteristicaController {
    @Autowired
    private CaracteristicaService caracteristicaService;
/*
    @PostMapping
    public ResponseEntity<Caracteristica> guardar(@RequestBody CaracteristicaDTO caracteristica) {
        return ResponseEntity.ok(caracteristicaService.guardar(caracteristica));
    }
*/
    @GetMapping
    public ResponseEntity<List<Caracteristica>>  listar() {
        return ResponseEntity.ok(caracteristicaService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Caracteristica> buscar(@PathVariable Long id) {
        Caracteristica caracteristica = caracteristicaService.buscar(id);
            return ResponseEntity.ok(caracteristica);
        }
/*
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        Caracteristica caracteristicaBuscada = caracteristicaService.buscar(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Caracteristica> modificar(@PathVariable(name = "id") Long id, @RequestBody CaracteristicaDTO caracteristica) {
        return ResponseEntity.ok(caracteristicaService.modificar(id, caracteristica));
    }
 */
}
