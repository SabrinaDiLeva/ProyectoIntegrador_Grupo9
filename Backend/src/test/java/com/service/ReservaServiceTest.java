package com.service;

import com.dto.command.ReservaDTO;
import com.model.Ciudad;
import com.model.Producto;
import com.model.Reserva;
import com.model.Rol;
import com.model.Usuario;
import com.repository.IProductoRepository;
import com.repository.IReservaRepository;
import com.repository.IUsuarioRepository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.server.ResponseStatusException;

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
public class ReservaServiceTest {
    @Mock
    IReservaRepository reservaRepository;
    @Mock
    IUsuarioRepository usuarioRepository;
    @Mock
    IProductoRepository productoRepository;
    @InjectMocks
    private ReservaService reservaService;


    @Test
    public void agregarReserva(){
            ReservaDTO reservaDTO = new ReservaDTO(1L,LocalDateTime.of(2022,10,10,15,0),LocalDateTime.of(2022,10,15,15,0),1l,1l);
            Usuario usuario = new Usuario(1L,"nombre","apellido","mail","contrasenia","ciudad",new Rol());
            Producto producto = new Producto(1l,"nombre",10,"titulo","descripcion");

            Reserva reserva = reservaDTO.newReserva(usuario,producto);
            when(reservaRepository.save(ArgumentMatchers.any(Reserva.class))).thenReturn(reserva);
            when(usuarioRepository.findById(1L)).thenReturn(Optional.of(usuario));
            when(productoRepository.findById(1L)).thenReturn(Optional.of(producto));

            assertThat(reservaService.guardar(reservaDTO))
                    .extracting("inicio", "fin", "usuario.id","producto.id")
                    .containsExactly(
                            reservaDTO.getInicio(),
                            reservaDTO.getFin(),
                            reservaDTO.getUsuario(),
                            reservaDTO.getProducto()
                    );
    }

    
    @Test
    public void listarReservas(){
            ReservaDTO[] reservas = {new ReservaDTO(1L,LocalDateTime.of(2022,10,10,15,0),LocalDateTime.of(2022,10,15,15,0),1l,1l),
                new ReservaDTO(2L,LocalDateTime.of(2022,10,10,15,0),LocalDateTime.of(2022,10,15,15,0),1l,1l)};
            List<ReservaDTO> lista = new ArrayList<>(Arrays.asList(reservas));
            List<Reserva> lista_reservas = lista.stream().map(c -> c.newReserva(new Usuario(c.getUsuario(), "nombre", "apellido","mail","contrasenia","ciudad",new Rol()),
                    new Producto(c.getProducto(),"nombre",10,"titulo","descripcion"))).toList();
            when(reservaRepository.findAll()).thenReturn(lista_reservas);
            List<Reserva> lista_c = reservaService.listar();
            assertThat(lista_c).hasSizeGreaterThan(0)
                    .hasSameElementsAs(lista_reservas);
    }

    
    @Test
    public void buscarReserva(){
            final Long id = 1L;
            ReservaDTO reservaDTO = new ReservaDTO(1L,LocalDateTime.of(2022,10,10,15,0),LocalDateTime.of(2022,10,15,15,0),1l,1l);
            Usuario usuario = new Usuario(1L,"nombre","apellido","mail","contrasenia","ciudad",new Rol());
            Producto producto = new Producto(1l,"nombre",10,"titulo","descripcion");

            Reserva reserva = reservaDTO.newReserva(usuario,producto);
            when(usuarioRepository.findById(eq(id))).thenReturn(Optional.of(usuario));
            when(productoRepository.findById(eq(id))).thenReturn(Optional.of(producto));
            when(reservaRepository.findById(id)).thenReturn(Optional.of(reserva));
            when(reservaRepository.save(ArgumentMatchers.any(Reserva.class))).thenReturn(reserva);
           
            assertThat(reservaService.guardar(reservaDTO))
                    .extracting("inicio", "fin", "usuario.id","producto.id")
                    .containsExactly(
                            reservaDTO.getInicio(),
                            reservaDTO.getFin(),
                            reservaDTO.getUsuario(),
                            reservaDTO.getProducto()
                    );
    }
    
    @Test
    public void listarReservasVacios(){
            List<Reserva> lista_reservas = new ArrayList<>();
            when(reservaRepository.findAll()).thenReturn(lista_reservas);
            List<Reserva> lista = reservaService.listar();
            assertThat(lista)
                    .hasSize(0)
                    .hasSameElementsAs(lista_reservas);
    }
    
    @Test
    public void actualizarReserva(){
            final Long id = 1L;
            ReservaDTO reservaDTO = new ReservaDTO(1L,LocalDateTime.of(2022,10,10,15,0),LocalDateTime.of(2022,10,15,15,0),1l,1l);
            Usuario usuario = new Usuario(1L,"nombre","apellido","mail","contrasenia","ciudad",new Rol());
            Producto producto = new Producto(1l,"nombre",10,"titulo","descripcion");


            Reserva reserva = reservaDTO.newReserva(usuario, producto);

            when(usuarioRepository.findById(eq(id))).thenReturn(Optional.of(usuario));
            when(productoRepository.findById(eq(id))).thenReturn(Optional.of(producto));
            when(reservaRepository.findById(eq(id))).thenReturn(Optional.of(reserva));
            when(reservaRepository.save(ArgumentMatchers.any(Reserva.class))).thenReturn(reserva);

            assertThat(reservaService.guardar(reservaDTO))
                    .extracting("inicio", "fin", "usuario.id","producto.id")
                    .containsExactly(
                            reservaDTO.getInicio(),
                            reservaDTO.getFin(),
                            reservaDTO.getUsuario(),
                            reservaDTO.getProducto()
                    );
    }

    @Test
    public void eliminarReserva(){
            final Long id = 1L;
            Reserva reserva= new Reserva(1L,LocalDateTime.of(2022,10,10,15,0),LocalDateTime.of(2022,10,15,15,0),new Usuario(),new Producto());
            when(reservaRepository.findById(eq(id))).thenReturn(Optional.of(reserva));
            reservaService.eliminar(id);
            verify(reservaRepository, times(1)).deleteById(id);
    }

    @Test
    public void agregarReservaConUsuarioQueNoExisteLanzaNotFound(){
            final Long id = 1L;
            ReservaDTO reservaDTO = new ReservaDTO(1L,LocalDateTime.of(2022,10,10,15,0),LocalDateTime.of(2022,10,15,15,0),1l,1l);
            Usuario usuario = new Usuario(1L,"nombre","apellido","mail","contrasenia","ciudad",new Rol());
            Producto producto = new Producto(1l,"nombre",10,"titulo","descripcion");

            Reserva reserva = reservaDTO.newReserva(usuario,producto);

            when(reservaRepository.save(ArgumentMatchers.any(Reserva.class))).thenReturn(reserva);
            when(usuarioRepository.findById(eq(id))).thenReturn(Optional.empty());
            when(productoRepository.findById(eq(id))).thenReturn(Optional.of(producto));

            Assertions.assertThrows( ResponseStatusException.class, () -> reservaService.guardar(reservaDTO));
    }

    @Test
    public void agregarReservaConProductoQueNoExisteLanzaNotFound(){
        final Long id = 1L;
        ReservaDTO reservaDTO = new ReservaDTO(1L,LocalDateTime.of(2022,10,10,15,0),LocalDateTime.of(2022,10,15,15,0),1l,1l);
        Usuario usuario = new Usuario(1L,"nombre","apellido","mail","contrasenia","ciudad",new Rol());
        Producto producto = new Producto(1l,"nombre",10,"titulo","descripcion");

        Reserva reserva = reservaDTO.newReserva(usuario,producto);

        when(reservaRepository.save(ArgumentMatchers.any(Reserva.class))).thenReturn(reserva);
        when(usuarioRepository.findById(eq(id))).thenReturn(Optional.of(usuario));
        when(productoRepository.findById(eq(id))).thenReturn(Optional.empty());

        Assertions.assertThrows( ResponseStatusException.class, () -> reservaService.guardar(reservaDTO));
    }

    @Test
    public void agregarProductoConCategoriaYCiudadQueNoExistenLanzaNotFound(){
        final Long id = 1L;
        ReservaDTO reservaDTO = new ReservaDTO(1L,LocalDateTime.of(2022,10,10,15,0),LocalDateTime.of(2022,10,15,15,0),1l,1l);
        Usuario usuario = new Usuario(1L,"nombre","apellido","mail","contrasenia","ciudad",new Rol());
        Producto producto = new Producto(1l,"nombre",10,"titulo","descripcion");

        Reserva reserva = reservaDTO.newReserva(usuario,producto);

        when(reservaRepository.save(ArgumentMatchers.any(Reserva.class))).thenReturn(reserva);
        when(usuarioRepository.findById(eq(id))).thenReturn(Optional.empty());
        when(productoRepository.findById(eq(id))).thenReturn(Optional.empty());

        Assertions.assertThrows( ResponseStatusException.class, () -> reservaService.guardar(reservaDTO));
    }
    
    /*@Test
    public void buscarCaracteristicaQueNoExisteLanzaNotFound(){
        final Long id = 1L;
        CaracteristicaDTO caracteristicaDTO = new CaracteristicaDTO( 1L, "titulo","descripcion");
        when(caracterisicaRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(ResponseStatusException.class, () -> caracteristicaService.guardar(caracteristicaDTO));
    }*/
}