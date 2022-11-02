package com.service;

import com.model.Ciudad;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ICiudadService {
    List<Ciudad> listar();
    Ciudad guardar(Ciudad ciudad);
    Optional<Ciudad> buscar(Long id);
    void eliminar(Long id);
    Ciudad modificar(Ciudad ciudad);
}