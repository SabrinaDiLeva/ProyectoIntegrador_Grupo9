package com.example.Backend.service;

import com.example.Backend.dto.command.CategoriaDTO;
import com.example.Backend.dto.command.UsuarioDTO;
import com.example.Backend.model.Categoria;
import com.example.Backend.repository.ICategoriaRepository;
import com.example.Backend.repository.IImagenRepository;
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

    @Override
    public UsuarioDTO findByCorreo(String email) {
        return null;
    }
}