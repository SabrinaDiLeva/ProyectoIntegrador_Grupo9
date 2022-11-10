package com.service;

//import com.dto.command.ProductoDTO;
import com.dto.command.ProductoDTO;
import com.model.Producto;
import com.repository.IProductoRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class ProductoServiceTest {
        @Mock
        IProductoRepository productoRepository;
        @InjectMocks
        private ProductoService productoService;

/*
        @Test
        public void agregarProducto(){
            ProductoDTO productoDTO = new ProductoDTO( 1L, "titulo","descripcion", "url-imagen");
            Producto producto = new Producto(productoDTO);
            when(productoRepository.save(any(Producto.class))).thenReturn(producto);

            //verify(productoRepository, times(1)).save(producto);
            assertThat(productoService.guardar(productoDTO))
                    .extracting("titulo", "descripcion", "urlImagen")
                    .containsExactly(
                            productoDTO.getTitulo(),
                            productoDTO.getDescripcion(),
                            productoDTO.getUrlImagen()
                    );
        }

        @Test
        public void listarProductos(){
            Producto[] productos = {new Producto(1l,"test", "test", "test"), new Producto(2l,"test", "test", "test")};
            List<Producto> lista_productos = new ArrayList<>(Arrays.asList(productos));
            when(productoRepository.findAll()).thenReturn(lista_productos);
            List<Producto> lista = productoService.listar();
            assertThat(lista).hasSizeGreaterThan(0)
                    .hasSameElementsAs(lista_productos);
        }

        @Test
        public void listarProductosVacias(){
            List<Producto> lista_productos = new ArrayList<>();
            when(productoRepository.findAll()).thenReturn(lista_productos);
            List<Producto> lista = productoService.listar();
            assertThat(lista)
                    .hasSize(0)
                    .hasSameElementsAs(lista_productos);
        }

        @Test
        public void actualizarProducto(){
            final Long id = 1L;
            ProductoDTO productoDTO = new ProductoDTO(1L, "Casa en la montaña", "Un casa linda", "https://st.hzcdn.com/simgs/13c1c37a0527bc49_4-6348/home-design.jpg");
            Producto producto = new Producto(productoDTO);
            when(productoRepository.findById(eq(id))).thenReturn(Optional.of(producto));
            when(productoRepository.save(any(Producto.class))).thenReturn(producto);

            //verify(productoRepository, times(1)).save(producto);
            assertThat(productoService.modificar(id, productoDTO))
                    .extracting("titulo", "descripcion", "urlImagen")
                    .containsExactly(
                            productoDTO.getTitulo(),
                            productoDTO.getDescripcion(),
                            productoDTO.getUrlImagen()
                    );
        }

        @Test
        public void eliminarProducto(){
            final Long id = 1L;
            Producto producto = new Producto(1L, "Casa en la montaña", "Un casa linda", "https://st.hzcdn.com/simgs/13c1c37a0527bc49_4-6348/home-design.jpg");
            when(productoRepository.findById(eq(id))).thenReturn(Optional.of(producto));
            productoService.eliminar(id);
            verify(productoRepository, times(1)).deleteById(id);
        }
    }
*/
}