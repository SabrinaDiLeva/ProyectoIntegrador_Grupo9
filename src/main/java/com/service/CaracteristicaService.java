package com.service;

import com.model.Caracteristica;
import com.repository.ICaracteristicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CaracteristicaService implements IService<Caracteristica> {
    private ICaracteristicaRepository iCaracteristicaRepository;

    @Autowired
    public CaracteristicaService(ICaracteristicaRepository iCaracteristicaRepository) {
        this.iCaracteristicaRepository = iCaracteristicaRepository;
    }

    @Override
    public List<Caracteristica> listar() {
        return iCaracteristicaRepository.findAll();
    }

    @Override
    public Caracteristica guardar(Caracteristica caracteristica) {
        return iCaracteristicaRepository.save(caracteristica);
    }

    @Override
    public Optional<Caracteristica> buscar(Long id) {
        return iCaracteristicaRepository.findById(id);
    }

    @Override
    public void eliminar(Long id) {
        iCaracteristicaRepository.deleteById(id);
    }

    @Override
    public Caracteristica modificar(Caracteristica caracteristica) {
        return iCaracteristicaRepository.save(caracteristica);
    }
}