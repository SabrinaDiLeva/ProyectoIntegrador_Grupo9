package com.service;

import com.dto.command.CategoriaDTO;
import com.model.Categoria;
import com.repository.ICategoriaRepository;
import com.repository.IImagenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService implements IService<Categoria,CategoriaDTO> {
    private ICategoriaRepository iCategoriaRepository;

    @Autowired
    public CategoriaService(ICategoriaRepository iCategoriaRepository, IImagenRepository iImagenRepository) {
        this.iCategoriaRepository = iCategoriaRepository;

    }

    @Override
    public List<Categoria> listar() {
        return iCategoriaRepository.findAll();
    }

    @Override
    public Categoria guardar(CategoriaDTO categoria) {
        //Imagen img = iImagenRepository.findById(categoria.getImagenId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        //Optional<Categoria> result = ( img.getProducto() == null )?  Optional.of(iCategoriaRepository.save(categoria.newCategoria(img))) : Optional.empty();
        Optional<Categoria> result =  Optional.of(iCategoriaRepository.save(categoria.newCategoria()));
        return result.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
    }

    @Override
    public Categoria buscar(Long id) {
        return iCategoriaRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void eliminar(Long id) {
        this.buscar(id);
        iCategoriaRepository.deleteById(id);
    }

    @Override
    public Categoria modificar(Long id, CategoriaDTO dto) {
        Categoria categoria = this.buscar(id);
        return this.guardar(dto.update(categoria));
    }
}