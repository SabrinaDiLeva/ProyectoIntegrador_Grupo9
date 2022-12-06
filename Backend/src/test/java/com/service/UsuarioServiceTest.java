package com.service;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.server.ResponseStatusException;

import com.dto.command.UsuarioDTO;
import com.model.Rol;
import com.model.Usuario;
import com.repository.IRolRepository;
import com.repository.IUsuarioRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class UsuarioServiceTest {
    @Mock
    IUsuarioRepository usuarioRepository;
    @Mock
    IRolRepository rolRepository;

    @InjectMocks
    private UsuarioService usuarioService;


    @Test
    public void agregarUsuario(){
            UsuarioDTO usuarioDTO = new UsuarioDTO(1l,"nombre","apellido","mail","contrasenia","ciudad",1l);
            Rol rol = new Rol(1L,"rol");
           
            Usuario usuario = usuarioDTO.newUsuario(rol);
            when(usuarioRepository.save(ArgumentMatchers.any(Usuario.class))).thenReturn(usuario);
            when(rolRepository.findById(1L)).thenReturn(Optional.of(rol));

            assertThat(usuarioService.guardar(usuarioDTO))
                    .extracting("nombre","apellido","email","contrasenia","ciudad","rol.id")
                    .containsExactly(
                            usuarioDTO.getNombre(),
                            usuarioDTO.getApellido(),
                            usuarioDTO.getEmail(),
                            usuarioDTO.getContrasenia(),
                            usuarioDTO.getCiudad(),
                            usuarioDTO.getRolId()
                    );
    }

    
    @Test
    public void listarUsuarioss(){
            UsuarioDTO[] usuarios = {new UsuarioDTO(1l,"nombre","apellido","mail","contrasenia","ciudad",1l),
            new UsuarioDTO(2l,"nombre","apellido","mail","contrasenia","ciudad",1l)};
            List<UsuarioDTO> lista = new ArrayList<>(Arrays.asList(usuarios));
            List<Usuario> lista_usuarios = lista.stream().map(c -> c.newUsuario(new Rol(1l,"rol"))).toList();
            when(usuarioRepository.findAll()).thenReturn(lista_usuarios);
            List<Usuario> lista_c = usuarioService.listar();
            assertThat(lista_c).hasSizeGreaterThan(0)
                    .hasSameElementsAs(lista_usuarios);
    }

    
    @Test
    public void buscarUsuario(){
            final Long id = 1L;
            UsuarioDTO usuarioDTO = new UsuarioDTO(1l,"nombre","apellido","mail","contrasenia","ciudad",1l);
            Rol rol = new Rol(1L,"rol");
           
            Usuario usuario = usuarioDTO.newUsuario(rol);
            when(rolRepository.findById(eq(id))).thenReturn(Optional.of(rol));
            when(usuarioRepository.findById(id)).thenReturn(Optional.of(usuario));
            when(usuarioRepository.save(ArgumentMatchers.any(Usuario.class))).thenReturn(usuario);
           
            assertThat(usuarioService.guardar(usuarioDTO))
                    .extracting("nombre","apellido","email","contrasenia","ciudad","rol.id")
                    .containsExactly(
                            usuarioDTO.getNombre(),
                            usuarioDTO.getApellido(),
                            usuarioDTO.getEmail(),
                            usuarioDTO.getContrasenia(),
                            usuarioDTO.getCiudad(),
                            usuarioDTO.getRolId()
                    );
    }
    
    @Test
    public void listarUsuariosVacios(){
            List<Usuario> lista_usuarios = new ArrayList<>();
            when(usuarioRepository.findAll()).thenReturn(lista_usuarios);
            List<Usuario> lista = usuarioService.listar();
            assertThat(lista)
                    .hasSize(0)
                    .hasSameElementsAs(lista_usuarios);
    }
    
    @Test
    public void actualizarUsuario(){
            final Long id = 1L;
            UsuarioDTO usuarioDTO = new UsuarioDTO(1l,"nombre","apellido","mail","contrasenia","ciudad",1l);
            Rol rol = new Rol(1L,"rol");
           

            Usuario usuario = usuarioDTO.newUsuario(rol);

            when(rolRepository.findById(eq(id))).thenReturn(Optional.of(rol));
            when(usuarioRepository.findById(eq(id))).thenReturn(Optional.of(usuario));
            when(usuarioRepository.save(ArgumentMatchers.any(Usuario.class))).thenReturn(usuario);

            assertThat(usuarioService.guardar(usuarioDTO))
                    .extracting("nombre","apellido","email","contrasenia","ciudad","rol.id")
                    .containsExactly(
                            usuarioDTO.getNombre(),
                            usuarioDTO.getApellido(),
                            usuarioDTO.getEmail(),
                            usuarioDTO.getContrasenia(),
                            usuarioDTO.getCiudad(),
                            usuarioDTO.getRolId()
                    );
    }

    @Test
    public void eliminarUsuario(){
            final Long id = 1L;
            Usuario usuario= new Usuario(1l,"nombre","apellido","mail","contrasenia","ciudad",new Rol());
            when(usuarioRepository.findById(eq(id))).thenReturn(Optional.of(usuario));
            usuarioService.eliminar(id);
            verify(usuarioRepository, times(1)).deleteById(id);
    }

    @Test
    public void agregarUsuarioConRolQueNoExisteLanzaNotFound(){
            final Long id = 1L;
            UsuarioDTO usuarioDTO = new UsuarioDTO(1l,"nombre","apellido","mail","contrasenia","ciudad",1l);
            Rol rol = new Rol(1L,"rol");
           

            Usuario usuario = usuarioDTO.newUsuario(rol);

            when(rolRepository.findById(eq(id))).thenReturn(Optional.empty());
            when(usuarioRepository.findById(eq(id))).thenReturn(Optional.of(usuario));
            when(usuarioRepository.save(ArgumentMatchers.any(Usuario.class))).thenReturn(usuario);

            Assertions.assertThrows( ResponseStatusException.class, () -> usuarioService.guardar(usuarioDTO));
    }

    /*@Test
    public void buscarCaracteristicaQueNoExisteLanzaNotFound(){
        final Long id = 1L;
        CaracteristicaDTO caracteristicaDTO = new CaracteristicaDTO( 1L, "titulo","descripcion");
        when(caracterisicaRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(ResponseStatusException.class, () -> caracteristicaService.guardar(caracteristicaDTO));
    }*/
}
