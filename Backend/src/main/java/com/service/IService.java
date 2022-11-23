package com.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IService<T,R> {
    List<T> listar();
    T guardar(R item);
    T buscar(Long id);
    void eliminar(Long id);
    T modificar(Long id, R i);
}