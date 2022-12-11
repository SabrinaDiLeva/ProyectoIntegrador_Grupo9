package com.example.Backend.service;

import com.example.Backend.dto.command.UsuarioDTO;

import java.util.List;


public interface IService<T, R> {
    List<T> listar();

    T guardar(R item);

    T buscar(Long id);

    void eliminar(Long id);

    T modificar(Long id, R i);

    UsuarioDTO findByCorreo(String email);
}