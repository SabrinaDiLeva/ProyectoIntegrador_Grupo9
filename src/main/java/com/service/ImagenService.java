package com.service;

import com.model.Imagen;
import com.repository.IImagenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
    public Imagen buscar(Long id) {
        return iImagenRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void eliminar(Long id) {
        this.buscar(id);
        iImagenRepository.deleteById(id);
    }

    @Override
    public Imagen modificar(Long id, Imagen imagen) {
        Imagen img = this.buscar(id);
        return iImagenRepository.save(img.update(imagen));
    }
}

