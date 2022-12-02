package com.example.Backend.controller;

import com.example.Backend.dto.command.UsuarioDTO;
import com.example.Backend.model.Usuario;
import com.example.Backend.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping
    public ResponseEntity<Map<String, Object>> crear(@RequestBody UsuarioDTO usuarioDTO){
        Map<String, Object> response = new HashMap<>();
        String passWEncrypt = passwordEncoder.encode(usuarioDTO.getContrasenia());
        usuarioDTO.setContrasenia(passWEncrypt);
        response.put("respuesta",usuarioService.guardar(usuarioDTO));
        return new ResponseEntity(response, HttpStatus.CREATED);
    }



    /*
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public ResponseEntity<List<Usuario>>  listar() {
        return ResponseEntity.ok(usuarioService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscar(@PathVariable Long id) {
        Usuario usuario = usuarioService.buscar(id);
        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        usuarioService.eliminar(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> modificar(@PathVariable( name = "id") Long id, @RequestBody UsuarioDTO usuario) {
        return ResponseEntity.ok(usuarioService.modificar(id, usuario));
    }
     */
}