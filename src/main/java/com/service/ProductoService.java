package com.service;

import com.dto.command.ProductoDTO;
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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoService implements IService<Producto, ProductoDTO>{
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
    public Producto guardar(ProductoDTO producto) {
        Categoria categoria = iCategoriaRepository.findById(producto.getCategoriaId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        Ciudad ciudad = iCiudadRepository.findById(producto.getCiudadId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        Producto p = producto.newProducto(ciudad,categoria);
        return iProductoRepository.save(p);
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
    public Producto modificar(Long id, ProductoDTO dto) {
        Producto producto = this.buscar(id);
        return this.guardar(dto.update(producto));
    }

    public List<Producto> listarPorIdCategoria(Long id) {
        return iProductoRepository.findAllByCategoria_Id(id);
    }
    public List<Producto> listarPorIdCiudad(Long id) {
        return iProductoRepository.findAllByCiudad_Id(id);
    }

    public List<Producto> listarRandom() {
        //EN ESTE CASO LE PEDI 3 PORQUE TENEMOS SOLO 8 PRODUCTOS CARGADOS EN LA BASE
        List<Producto> productos= iProductoRepository.findAll();
        Collections.shuffle(productos);
        return productos.subList(0,3);
    }
}
