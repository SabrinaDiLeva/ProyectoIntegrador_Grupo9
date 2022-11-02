package com.service;

import com.model.Imagen;
import com.repository.IImagenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImagenService implements IService<Imagen, Imagen>{
    private IImagenRepository iImagenRepository;

    @Autowired
    public ImagenService(IImagenRepository iImagenRepository) {
        this.iImagenRepository = iImagenRepository;
    }

    @Override
    public List<Imagen> listar() {
        return iImagenRepository.findAll();
    }

    @Override
    public Imagen guardar(Imagen imagen) {
        return iImagenRepository.save(imagen);
    }

    @Override
    public Optional<Imagen> buscar(Long id) {
        return iImagenRepository.findById(id);
    }

    @Override
    public void eliminar(Long id) {
        iImagenRepository.deleteById(id);
    }

    @Override
    public Imagen modificar(Long id, Imagen imagen) {
        return iImagenRepository.save(imagen);
    }
}

