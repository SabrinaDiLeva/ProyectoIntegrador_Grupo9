package com.service;

import com.dto.command.CategoriaDTO;
import com.model.Categoria;
import com.repository.ICategoriaRepository;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class CategoriaServiceTest {
    @Mock
    ICategoriaRepository categoriaRepository;
    @InjectMocks
    private CategoriaService categoriaService;
/*
    @Test
    public void agregarCategoria(){
        CategoriaDTO categoriaDTO = new CategoriaDTO( 1l, "titulo","descripcion", "url-imagen");
        Categoria categoria = new Categoria(categoriaDTO);
        when(categoriaRepository.save(any(Categoria.class))).thenReturn(categoria);

        //verify(categoriaRepository, times(1)).save(categoria);
        assertThat(categoriaService.guardar(categoriaDTO))
                .extracting("titulo", "descripcion", "urlImagen")
                .containsExactly(
                        categoriaDTO.getTitulo(),
                        categoriaDTO.getDescripcion(),
                        categoriaDTO.getUrlImagen()
                );
    }

    @Test
    public void listarCategorias(){
        Categoria[] categorias = {new Categoria(1l,"test", "test", "test"), new Categoria(2l,"test", "test", "test")};
        List<Categoria> lista_categorias = new ArrayList<>(Arrays.asList(categorias));
        when(categoriaRepository.findAll()).thenReturn(lista_categorias);
        List<Categoria> lista = categoriaService.listar();
        assertThat(lista).hasSizeGreaterThan(0)
                .hasSameElementsAs(lista_categorias);
    }

    @Test
    public void listarCategoriasVacias(){
        List<Categoria> lista_categorias = new ArrayList<>();
        when(categoriaRepository.findAll()).thenReturn(lista_categorias);
        List<Categoria> lista = categoriaService.listar();
        assertThat(lista)
                .hasSize(0)
                .hasSameElementsAs(lista_categorias);
    }

    @Test
    public void actualizarCategoria(){
        final Long id = 1L;
        CategoriaDTO categoriaDTO = new CategoriaDTO(1L, "Casa en la montaña", "Un casa linda", "https://st.hzcdn.com/simgs/13c1c37a0527bc49_4-6348/home-design.jpg");
        Categoria categoria = new Categoria(categoriaDTO);
        when(categoriaRepository.findById(eq(id))).thenReturn(Optional.of(categoria));
        when(categoriaRepository.save(any(Categoria.class))).thenReturn(categoria);

        //verify(categoriaRepository, times(1)).save(categoria);
        assertThat(categoriaService.modificar(id, categoriaDTO))
            .extracting("titulo", "descripcion", "urlImagen")
            .containsExactly(
                categoriaDTO.getTitulo(),
                categoriaDTO.getDescripcion(),
                categoriaDTO.getUrlImagen()
            );
    }

    @Test
    public void eliminarCategoria(){
        final Long id = 1L;
        Categoria categoria = new Categoria(1L, "Casa en la montaña", "Un casa linda", "https://st.hzcdn.com/simgs/13c1c37a0527bc49_4-6348/home-design.jpg");
        when(categoriaRepository.findById(eq(id))).thenReturn(Optional.of(categoria));
        categoriaService.eliminar(id);
        verify(categoriaRepository, times(1)).deleteById(id);
    }*/
}
