package com.service;

import com.dto.command.CiudadDTO;
import com.model.Ciudad;
import com.repository.ICiudadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CiudadService implements IService<Ciudad, CiudadDTO>{
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
    public Ciudad guardar(CiudadDTO ciudad) {
        Ciudad c= new Ciudad(ciudad.getId(), ciudad.getNombre(), ciudad.getPais());
        return iCiudadRepository.save(c);
    }

    @Override
    public Ciudad buscar(Long id) {
        return iCiudadRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void eliminar(Long id) {
        this.buscar(id);
        iCiudadRepository.deleteById(id);
    }


    @Override
    public Ciudad modificar(Long id, CiudadDTO dto) {
        Ciudad c = this.buscar(id);
        return this.guardar(dto.update(c));
    }
}