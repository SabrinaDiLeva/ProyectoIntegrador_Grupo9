package com.service;

import com.dto.command.CategoriaDTO;
import com.model.Categoria;
import com.repository.ICategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Optional<Categoria> buscar(Long id) {
        return iCategoriaRepository.findById(id);
    }

    @Override
    public void eliminar(Long id) {
        iCategoriaRepository.deleteById(id);
    }

    @Override
    public Categoria modificar(Long id, CategoriaDTO categoria) {
        Optional<Categoria> categoriaBuscada= iCategoriaRepository.findById(id);
        if (categoriaBuscada.isPresent()){
            return iCategoriaRepository.save(new Categoria(id, categoria));
        }
        return new Categoria();
    }
}
