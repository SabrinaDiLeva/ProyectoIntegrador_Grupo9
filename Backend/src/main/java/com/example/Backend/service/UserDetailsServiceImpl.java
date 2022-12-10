package com.example.Backend.service;

import com.example.Backend.dto.command.MainUserAuth;
import com.example.Backend.dto.command.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private IService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsuarioDTO usuarioDTO =  usuarioService.findByCorreo(username);
        return MainUserAuth.build(usuarioDTO);
    }
}
