package com.example.demo;

import com.model.Categoria;
import com.service.ICategoriaService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class CategoriaTest {
    @Autowired
    private ICategoriaService categoriaService;

    @Test
    @Order(1)
    public void agregarCategoria(){
        Categoria categoria_prueba = new Categoria(1l,"titulo","descrpcion", "url-imagen");
        categoriaService.guardar(categoria_prueba);
        Optional<Categoria> categoria_1 = categoriaService.buscar(1l);
        assertTrue(categoria_1.isPresent());
    }

    @Test
    @Order(2)
    public void listarCategoria(){
        List<Categoria> lista = categoriaService.listar();
        assertTrue(lista.size()>0);
    }

    @Test
    @Order(3)
    public void actualizarCategoria(){
        Categoria categoria_new = new Categoria(1l, "Casa en la montaña", "Un casa linda", "https://st.hzcdn.com/simgs/13c1c37a0527bc49_4-6348/home-design.jpg");
        categoriaService.modificar(categoria_new);
        Optional<Categoria> categoriaModificada = categoriaService.buscar(1l);
        assertEquals("Casa en la montaña",categoriaModificada.get().getTitulo());
    }

    @Test
    @Order(4)
    public void eliminarCategoria(){
        categoriaService.eliminar(1l);
        Optional<Categoria> categoriaEliminada = categoriaService.buscar(1l);
        assertFalse(categoriaEliminada.isPresent());
    }
}
