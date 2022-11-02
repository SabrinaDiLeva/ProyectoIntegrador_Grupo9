package com.service;

import com.model.Producto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IProductoService {
    List<Producto> listar();
    Producto guardar(Producto producto);
    Optional<Producto> buscar(Long id);
    void eliminar(Long id);
    Producto modificar(Producto producto);
}