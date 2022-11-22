package com.controller;

import com.dto.command.ReservaDTO;
import com.model.Reserva;
import com.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reserva")
public class ReservaController {
    @Autowired
    private ReservaService reservaService;

    @PostMapping
    public ResponseEntity<Reserva> guardar(@RequestBody ReservaDTO reserva) {
        return ResponseEntity.ok(reservaService.guardar(reserva));
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public ResponseEntity<List<Reserva>>  listar() {
        return ResponseEntity.ok(reservaService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reserva> buscar(@PathVariable Long id) {
        Reserva reserva = reservaService.buscar(id);
        return ResponseEntity.ok(reserva);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        reservaService.eliminar(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reserva> modificar(@PathVariable( name = "id") Long id, @RequestBody ReservaDTO reserva) {
        return ResponseEntity.ok(reservaService.modificar(id, reserva));
    }
}
