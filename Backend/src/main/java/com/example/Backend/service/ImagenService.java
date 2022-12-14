package com.example.Backend.service;
import com.example.Backend.dto.command.ImagenDTO;
import com.example.Backend.dto.command.UsuarioDTO;
import com.example.Backend.model.Imagen;
import com.example.Backend.model.Producto;
import com.example.Backend.repository.IImagenRepository;
import com.example.Backend.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

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

    @Override
    public UsuarioDTO findByCorreo(String email) {
        return null;
    }

    public List<Imagen> listarPorProducto(Long id) {
        return iImagenRepository.findAllByProducto_Id(id);
    }
}

