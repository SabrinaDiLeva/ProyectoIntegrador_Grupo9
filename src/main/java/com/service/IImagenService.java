package com.service;

import com.model.Imagen;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IImagenService {
    List<Imagen> listar();
    Imagen guardar(Imagen imagen);
    Optional<Imagen> buscar(Long id);
    void eliminar(Long id);
    Imagen modificar(Imagen imagen);
}