package com.service;

import com.model.Imagen;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IService<T,R> {
    List<T> listar();
    T guardar(R item);
    Optional<T> buscar(Long id);
    void eliminar(Long id);
    T modificar(Long id, R i);
}