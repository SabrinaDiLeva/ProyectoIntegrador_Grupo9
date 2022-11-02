package com.service;

import com.model.Imagen;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IService<T> {
    List<T> listar();
    T guardar(T item);
    Optional<T> buscar(Long id);
    void eliminar(Long id);
    T modificar(T i);
}