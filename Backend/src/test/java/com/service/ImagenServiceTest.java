package com.service;


import com.dto.command.ImagenDTO;
import com.model.Categoria;
import com.model.Ciudad;
import com.model.Imagen;
import com.model.Producto;
import com.repository.IImagenRepository;
import com.repository.IProductoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class ImagenServiceTest {
    @Mock
    IImagenRepository imagenRepository;

    @Mock
    IProductoRepository productoRepository;
    @InjectMocks
    private ImagenService imagenService;

    @Test
    public void agregarImagen(){
        ImagenDTO imagenDTO = new ImagenDTO( 1L, "titulo","url", 1L);
        Producto producto = new Producto(1L,"nombre",10,"titulo","descripcion",new Categoria(),new Ciudad());
        Imagen imagen = imagenDTO.newImagen(producto);
        when(imagenRepository.save(any(Imagen.class))).thenReturn(imagen);
        when(productoRepository.findById(1L)).thenReturn(Optional.of(producto));

        assertThat(imagenService.guardar(imagenDTO))
                .extracting("titulo", "url", "producto.id")
                .containsExactly(
                        imagenDTO.getTitulo(),
                        imagenDTO.getUrl(),
                        imagenDTO.getProductoId()
                );
    }
    
    @Test
    public void listarImagenes(){
        ImagenDTO[] imagenes = {new ImagenDTO(1l,"test", "test", 1L), new ImagenDTO(2l,"test", "test", 2L)};
        List<ImagenDTO> lista = new ArrayList<>(Arrays.asList(imagenes));
        List<Imagen> lista_imagenes= lista.stream().map(c -> c.newImagen(new Producto(c.getProductoId(),"nombre",10,"titulo","descripcion",new Categoria(),new Ciudad()))).toList();
        when(imagenRepository.findAll()).thenReturn(lista_imagenes);
        List<Imagen> lista_c = imagenService.listar();
        assertThat(lista_c).hasSizeGreaterThan(0)
                .hasSameElementsAs(lista_imagenes);
    }


    @Test
    public void buscarImagen(){
        final Long id = 1L;
        ImagenDTO imagenDTO = new ImagenDTO( id, "titulo","descripcion", id);
        Producto producto = new Producto(1L,"nombre",10,"titulo","descripcion",new Categoria(),new Ciudad());
        Imagen imagen = imagenDTO.newImagen(producto);
        when(productoRepository.findById(eq(id))).thenReturn(Optional.of(producto));
        when(imagenRepository.findById(id)).thenReturn(Optional.of(imagen));
        when(imagenRepository.save(any(Imagen.class))).thenReturn(imagen);

        assertThat(imagenService.guardar(imagenDTO))
                .extracting("titulo", "url", "producto.id")
                .containsExactly(
                        imagenDTO.getTitulo(),
                        imagenDTO.getUrl(),
                        imagenDTO.getProductoId()
                );
    }


    @Test
    public void listarImagenesVacias(){
        List<Imagen> lista_imagenes = new ArrayList<>();
        when(imagenRepository.findAll()).thenReturn(lista_imagenes);
        List<Imagen> lista = imagenService.listar();
        assertThat(lista)
                .hasSize(0)
                .hasSameElementsAs(lista_imagenes);
    }
    @Test
    public void actualizarImagen(){
        final Long id = 1L;
        ImagenDTO imagenDTO = new ImagenDTO(id, "test", "test", id);
        Producto producto = new Producto(1L,"nombre",10,"titulo","descripcion",new Categoria(),new Ciudad());
        Imagen imagen = imagenDTO.newImagen(producto);

        when(productoRepository.findById(eq(id))).thenReturn(Optional.of(producto));
        when(imagenRepository.findById(eq(id))).thenReturn(Optional.of(imagen));
        when(imagenRepository.save(any(Imagen.class))).thenReturn(imagen);

        assertThat(imagenService.guardar(imagenDTO))
                .extracting("titulo", "url", "producto.id")
                .containsExactly(
                        imagenDTO.getTitulo(),
                        imagenDTO.getUrl(),
                        imagenDTO.getProductoId()
                );
    }



    @Test
    public void eliminarImagen(){
        final Long id = 1L;
        Imagen imagen = new Imagen(id, "titulo", "url", new Producto());
        when(imagenRepository.findById(eq(id))).thenReturn(Optional.of(imagen));
        imagenService.eliminar(id);
        verify(imagenRepository, times(1)).deleteById(id);
    }


    @Test
    public void agregarImagenConProductoQueNoExisteLanzaNotFound(){
        final Long id = 1L;
        ImagenDTO imagenDTO = new ImagenDTO( 1L, "titulo","url", id);
        Producto producto = new Producto(1L,"nombre",10,"titulo","descripcion",new Categoria(),new Ciudad());
        Imagen imagen = imagenDTO.newImagen(producto);
        when(imagenRepository.save(any(Imagen.class))).thenReturn(imagen);
        when(productoRepository.findById(eq(id))).thenReturn(Optional.empty());

        Assertions.assertThrows( ResponseStatusException.class, () -> imagenService.guardar(imagenDTO));
    }

    /*
    @Test
    public void buscarImagenQueNoExisteLanzaNotFound(){
        final Long id = 1L;
        ImagenDTO imagenDTO = new ImagenDTO( 1L, "titulo","url", id);
        when(imagenRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(ResponseStatusException.class, () -> imagenService.guardar(imagenDTO));
    }
    */
}