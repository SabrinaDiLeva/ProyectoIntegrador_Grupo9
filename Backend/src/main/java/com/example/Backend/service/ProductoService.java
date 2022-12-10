package com.example.Backend.service;

import com.example.Backend.dto.command.ProductoDTO;
import com.example.Backend.dto.command.UsuarioDTO;
import com.example.Backend.model.Categoria;
import com.example.Backend.model.Ciudad;
import com.example.Backend.model.Fecha;
import com.example.Backend.model.Producto;

import com.example.Backend.repository.ICategoriaRepository;
import com.example.Backend.repository.ICiudadRepository;
import com.example.Backend.repository.IProductoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

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
        Producto p = producto.newProducto(categoria,ciudad);
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

    @Override
    public UsuarioDTO findByCorreo(String email) {
        return null;
    }

    public List<Producto> listarPorIdCategoria(Long id) {
        return iProductoRepository.findAllByCategoria_Id(id);
    }
    public List<Producto> listarPorIdCiudad(Long id) {
        return iProductoRepository.findAllByCiudad_Id(id);
    }

    public List<Producto> listarRandom() {
        //EN ESTE CASO LE PEDI 4 PORQUE TENEMOS SOLO 8 PRODUCTOS CARGADOS EN LA BASE
        List<Producto> productos= iProductoRepository.findAll();
        Collections.shuffle(productos);
        return productos.subList(0,4);
    }

    public List<Producto> filtrarBusqueda(Long ciudad, LocalDate inicio, LocalDate fin){
        List<Producto> productosCiudad = iProductoRepository.findAllByCiudad_Id(ciudad);
        List<Producto> resultado = new ArrayList<>();
        for(Producto producto: productosCiudad){
            Set<Fecha> fechas = producto.getFechasDisponibles();
            List<LocalDate> fechasDisponibles = new ArrayList<>();
            for(Fecha fecha : fechas){
                fechasDisponibles.add(fecha.getFecha());
            }
            List<LocalDate> fechasIngresadas = diasEntreDosFechas(inicio,fin);
            if(fechasDisponibles.containsAll(fechasIngresadas)){
                resultado.add(producto);
            }
        }

        return resultado;
    }

    public List<LocalDate> diasEntreDosFechas(LocalDate inicio, LocalDate fin){
        List<LocalDate> fechas = new ArrayList<>();
        LocalDate fecha = inicio;
        while(ChronoUnit.DAYS.between(fecha, fin)>=0){
            fechas.add(fecha);
            fecha=fecha.plusDays(1);
        }
        return fechas;
    }
}
