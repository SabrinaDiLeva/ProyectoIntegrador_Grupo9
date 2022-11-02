package com.service;

import com.model.Ciudad;
import com.repository.ICiudadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CiudadService implements IService<Ciudad>{
    private ICiudadRepository iCiudadRepository;

    @Autowired
    public CiudadService(ICiudadRepository iCiudadRepository) {
        this.iCiudadRepository = iCiudadRepository;
    }

    @Override
    public List<Ciudad> listar() {
        return iCiudadRepository.findAll();
    }

    @Override
    public Ciudad guardar(Ciudad ciudad) {
        return iCiudadRepository.save(ciudad);
    }

    @Override
    public Optional<Ciudad> buscar(Long id) {
        return iCiudadRepository.findById(id);
    }

    @Override
    public void eliminar(Long id) {
        iCiudadRepository.deleteById(id);
    }

    @Override
    public Ciudad modificar(Ciudad ciudad) {
        return iCiudadRepository.save(ciudad);
    }
}