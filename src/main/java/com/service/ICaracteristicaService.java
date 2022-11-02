package com.service;

import com.model.Caracteristica;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ICaracteristicaService {
    List<Caracteristica> listar();
    Caracteristica guardar(Caracteristica caracteristica);
    Optional<Caracteristica> buscar(Long id);
    void eliminar(Long id);
    Caracteristica modificar(Caracteristica caracteristica);
}
