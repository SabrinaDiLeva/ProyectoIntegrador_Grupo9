package com.service;

import com.model.Producto;
import com.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService implements IService<Producto, Producto>{
    private IProductoRepository iProductoRepository;

    @Autowired
    public ProductoService(IProductoRepository iProductoRepository) {
        this.iProductoRepository = iProductoRepository;
    }

    @Override
    public List<Producto> listar() {
        return iProductoRepository.findAll();
    }

    @Override
    public Producto guardar(Producto producto) {
        return iProductoRepository.save(producto);
    }

    @Override
    public Producto buscar(Long id) {
        return iProductoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void eliminar(Long id) {
        this.buscar(id);
        iProductoRepository.deleteById(id);
    }

    @Override
    public Producto modificar(Long id, Producto producto) {
        this.buscar(id);
        return iProductoRepository.save(producto);
    }
}
