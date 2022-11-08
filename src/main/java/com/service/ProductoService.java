package com.service;

import com.model.Categoria;
import com.model.Ciudad;
import com.model.Producto;
import com.repository.ICategoriaRepository;
import com.repository.ICiudadRepository;
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
    private ICategoriaRepository iCategoriaRepository;
    private ICiudadRepository iCiudadRepository;

    @Autowired
    public ProductoService(IProductoRepository iProductoRepository,ICategoriaRepository iCategoriaRepository,ICiudadRepository iCiudadRepository) {
        this.iProductoRepository = iProductoRepository;
        this.iCategoriaRepository = iCategoriaRepository;
        this.iCiudadRepository = iCiudadRepository;
    }

    @Override
    public List<Producto> listar() {
        return iProductoRepository.findAll();
    }

    @Override
    public Producto guardar(Producto producto) {
        Categoria categoria = this.iCategoriaRepository.findById(producto.getCategoria().getId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        Ciudad ciudad = this.iCiudadRepository.findById(producto.getCiudad().getId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        producto.setCiudad(ciudad);
        producto.setCategoria(categoria);
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
        Producto p = this.buscar(id);
        return this.guardar(p.update(producto));
    }

    public List<Producto> listarPorIdCategoria(Long id) {
        return iProductoRepository.findAllByCategoria_Id(id);
    }
    public List<Producto> listarPorIdCiudad(Long id) {
        return iProductoRepository.findAllByCiudad_Id(id);
    }
}
