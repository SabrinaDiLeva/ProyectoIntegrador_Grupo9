package com.service;

import com.dto.command.CategoriaDTO;
import com.model.Categoria;
import com.repository.ICategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService implements IService<Categoria,CategoriaDTO>{
    private ICategoriaRepository iCategoriaRepository;

    @Autowired
    public CategoriaService(ICategoriaRepository iCategoriaRepository) {
        this.iCategoriaRepository = iCategoriaRepository;
    }

    @Override
    public List<Categoria> listar() {
        return iCategoriaRepository.findAll();
    }

    @Override
    public Categoria guardar(CategoriaDTO categoria) {
        return iCategoriaRepository.save(new Categoria(categoria));
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
        return iCategoriaRepository.save(categoria.update(dto));
    }
}
