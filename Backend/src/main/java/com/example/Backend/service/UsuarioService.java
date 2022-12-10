package com.service;

import com.dto.command.UsuarioDTO;
import com.model.Rol;
import com.model.Usuario;
import com.repository.IUsuarioRepository;
import com.repository.IRolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService implements IService<Usuario,UsuarioDTO> {
    private IUsuarioRepository iUsuarioRepository;
    private IRolRepository iRolRepository;

    @Autowired
    public UsuarioService(IUsuarioRepository iUsuarioRepository,IRolRepository iRolRepository) {
        this.iUsuarioRepository = iUsuarioRepository;
        this.iRolRepository = iRolRepository;
    }

    @Override
    public List<Usuario> listar() {
        return iUsuarioRepository.findAll();
    }

    @Override
    public Usuario guardar(UsuarioDTO usuario) {
        Rol rol = iRolRepository.findById(usuario.getRolId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        Usuario u = usuario.newUsuario(rol);
        return iUsuarioRepository.save(u);
    }

    @Override
    public Usuario buscar(Long id) {
        return iUsuarioRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void eliminar(Long id) {
        this.buscar(id);
        iUsuarioRepository.deleteById(id);
    }

    @Override
    public Usuario modificar(Long id, UsuarioDTO dto) {
        Usuario usuario = this.buscar(id);
        return this.guardar(dto.update(usuario));
    }

}