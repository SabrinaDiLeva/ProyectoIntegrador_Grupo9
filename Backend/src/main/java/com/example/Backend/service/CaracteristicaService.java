package com.example.Backend.service;

import com.example.Backend.dto.command.CaracteristicaDTO;
import com.example.Backend.dto.command.UsuarioDTO;
import com.example.Backend.model.Caracteristica;
import com.example.Backend.repository.ICaracteristicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CaracteristicaService implements IService<Caracteristica, CaracteristicaDTO> {
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
    public Caracteristica guardar(CaracteristicaDTO caracteristica) {
        Caracteristica c = new Caracteristica(caracteristica.getId(),caracteristica.getNombre(),caracteristica.getDescripcion());
        return iCaracteristicaRepository.save(c);
    }

    @Override
    public Caracteristica buscar(Long id) {
        return iCaracteristicaRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void eliminar(Long id) {
        this.buscar(id);
        iCaracteristicaRepository.deleteById(id);
    }

    @Override
    public Caracteristica modificar(Long id, CaracteristicaDTO dto) {
        Caracteristica caracteristica = this.buscar(id);
        return this.guardar(dto.update(caracteristica));
    }

    @Override
    public UsuarioDTO findByCorreo(String email) {
        return null;
    }
}