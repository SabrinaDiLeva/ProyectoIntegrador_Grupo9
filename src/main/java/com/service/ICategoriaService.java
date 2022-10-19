package com.service;

import com.model.Categoria;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ICategoriaService {
    List<Categoria> listar();
    Categoria guardar(Categoria categoria);
    Optional<Categoria> buscar(Long id);
    void eliminar(Long id);
    Categoria modificar(Categoria categoria);
}
