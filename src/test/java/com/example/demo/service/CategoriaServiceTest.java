package com.example.demo.service;

import com.model.Categoria;
import com.repository.ICategoriaRepository;
import com.service.CategoriaService;
import com.service.ICategoriaService;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class CategoriaServiceTest {
    @Mock
    ICategoriaRepository categoriaRepository;
    @InjectMocks
    private CategoriaService categoriaService;

    @Test
    public void agregarCategoria(){
        Categoria categoria_prueba = new Categoria(1l,"titulo","descrpcion", "url-imagen");
        when(categoriaRepository.save(categoria_prueba)).thenReturn(categoria_prueba);
        categoriaService.guardar(categoria_prueba);
        Assertions.assertDoesNotThrow(() -> categoriaService.guardar(categoria_prueba));
        Assertions.assertEquals(categoriaService.guardar(categoria_prueba), categoria_prueba);
    }

    @Test
    public void listarCategorias(){
        Categoria[] categorias = {new Categoria(1l,"test", "test", "test"), new Categoria(2l,"test", "test", "test")};
        List<Categoria> lista_categorias = new ArrayList<>(Arrays.asList(categorias));
        when(categoriaRepository.findAll()).thenReturn(lista_categorias);
        List<Categoria> lista = categoriaService.listar();
        assertTrue(lista.size()>0);
        assertEquals(lista_categorias, lista);
    }

    @Test
    public void listarCategoriasVacias(){
        List<Categoria> lista_categorias = new ArrayList<>();
        when(categoriaRepository.findAll()).thenReturn(lista_categorias);
        List<Categoria> lista = categoriaService.listar();
        assertEquals(lista.size(), 0);
        assertEquals(lista_categorias, lista);
    }

    @Test
    public void actualizarCategoria(){
        Categoria categoria_new = new Categoria(1l, "Casa en la montaña", "Un casa linda", "https://st.hzcdn.com/simgs/13c1c37a0527bc49_4-6348/home-design.jpg");
        when(categoriaRepository.save(categoria_new)).thenReturn(categoria_new);
        assertEquals(categoria_new,categoriaService.modificar(categoria_new));
    }

    @Test
    @Order(4)
    public void eliminarCategoria(){
        categoriaService.eliminar(1l);
        verify(categoriaRepository).deleteById(1l);
    }
}
