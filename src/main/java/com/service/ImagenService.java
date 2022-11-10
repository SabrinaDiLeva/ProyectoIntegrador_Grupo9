package com.service;

import com.dto.command.ImagenDTO;
import com.model.Imagen;
import com.model.Producto;
import com.repository.IImagenRepository;
import com.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ImagenService implements IService<Imagen, ImagenDTO>{
    private IImagenRepository iImagenRepository;
    private IProductoRepository iProductoRepository;

    @Autowired
    public ImagenService(IImagenRepository iImagenRepository, IProductoRepository iProductoRepository) {
        this.iImagenRepository = iImagenRepository;
        this.iProductoRepository = iProductoRepository;
    }

    @Override
    public List<Imagen> listar() {
        return iImagenRepository.findAll();
    }

    @Override
    public Imagen guardar(ImagenDTO imagen) {
        if(imagen.getProductoId()!=null){
            Producto prod = iProductoRepository.findById(imagen.getProductoId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
            Imagen i = imagen.newImagen(prod);
            return iImagenRepository.save(i);
        }else{
            Imagen i = new Imagen(imagen.getId(), imagen.getTitulo(), imagen.getUrl());
            return iImagenRepository.save(i);
        }

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
    public Imagen modificar(Long id, ImagenDTO dto) {
        Imagen imagen = this.buscar(id);
        return this.guardar(dto.update(imagen));
    }
}

