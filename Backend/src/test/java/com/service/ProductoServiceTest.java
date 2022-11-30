package com.service;

//import com.dto.command.ProductoDTO;
import com.dto.command.ProductoDTO;
import com.model.Categoria;
import com.model.Ciudad;
import com.model.Imagen;
import com.model.Producto;
import com.repository.ICategoriaRepository;
import com.repository.ICiudadRepository;
import com.repository.IProductoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.server.ResponseStatusException;

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
public class ProductoServiceTest {
        /*@Mock
        IProductoRepository productoRepository;
        @Mock
        ICategoriaRepository categoriaRepository;
        @Mock
        ICiudadRepository ciudadRepository;
        @InjectMocks
        private ProductoService productoService;


        @Test
        public void agregarProducto(){
                ProductoDTO productoDTO = new ProductoDTO(1L,"nombre",10,"titulo","descripcion","fechas","normas","seguridad","cancelacion",1l,1l);
                Categoria categoria = new Categoria(1l,"titulo","descripcion",new Imagen());
                Ciudad ciudad = new Ciudad(1l,"nombre","pais");

                Producto producto = productoDTO.newProducto(categoria,ciudad);
                when(productoRepository.save(ArgumentMatchers.any(Producto.class))).thenReturn(producto);
                when(categoriaRepository.findById(1L)).thenReturn(Optional.of(categoria));
                when(ciudadRepository.findById(1L)).thenReturn(Optional.of(ciudad));

                assertThat(productoService.guardar(productoDTO))
                        .extracting("nombre", "calificacion", "titulo","descripcion","fechasDisponibles","normas","seguridad","cancelacion","categoria.id","ciudad.id")
                        .containsExactly(
                                productoDTO.getNombre(),
                                productoDTO.getCalificacion(),
                                productoDTO.getTitulo(),
                                productoDTO.getDescripcion(),
                                productoDTO.getFechas_disponibles(),
                                productoDTO.getNormas(),
                                productoDTO.getSeguridad(),
                                productoDTO.getCancelacion(),
                                productoDTO.getCategoriaId(),
                                productoDTO.getCiudadId()
                        );
        }



        @Test
        public void listarProductos(){
                ProductoDTO[] productos = {new ProductoDTO(1L,"nombre",10,"titulo","descripcion","fechas","normas","seguridad","cancelacion",1l,1l),
                        new ProductoDTO(1L,"nombre",10,"titulo","descripcion","fechas","normas","seguridad","cancelacion",1l,1l)};
                List<ProductoDTO> lista = new ArrayList<>(Arrays.asList(productos));
                List<Producto> lista_productos = lista.stream().map(c -> c.newProducto(new Categoria(c.getCategoriaId(), "titulo", "descripcion",new Imagen()),
                        new Ciudad(c.getCiudadId(),"nombre","pais"))).toList();
                when(productoRepository.findAll()).thenReturn(lista_productos);
                List<Producto> lista_c = productoService.listar();
                assertThat(lista_c).hasSizeGreaterThan(0)
                        .hasSameElementsAs(lista_productos);
        }

        @Test
        public void buscarProducto(){
                final Long id = 1L;
                ProductoDTO productoDTO = new ProductoDTO(1L,"nombre",10,"titulo","descripcion","fechas","normas","seguridad","cancelacion",1l,1l);;
                Categoria categoria = new Categoria(1l,"titulo","descripcion",new Imagen());
                Ciudad ciudad = new Ciudad(1l,"nombre","pais");

                Producto producto = productoDTO.newProducto(categoria,ciudad);
                when(categoriaRepository.findById(eq(id))).thenReturn(Optional.of(categoria));
                when(ciudadRepository.findById(eq(id))).thenReturn(Optional.of(ciudad));
                when(productoRepository.findById(id)).thenReturn(Optional.of(producto));
                when(productoRepository.save(ArgumentMatchers.any(Producto.class))).thenReturn(producto);

                assertThat(productoService.guardar(productoDTO))
                        .extracting("nombre", "calificacion", "titulo","descripcion","fechasDisponibles","normas","seguridad","cancelacion","categoria.id","ciudad.id")
                        .containsExactly(
                                productoDTO.getNombre(),
                                productoDTO.getCalificacion(),
                                productoDTO.getTitulo(),
                                productoDTO.getDescripcion(),
                                productoDTO.getFechas_disponibles(),
                                productoDTO.getNormas(),
                                productoDTO.getSeguridad(),
                                productoDTO.getCancelacion(),
                                productoDTO.getCategoriaId(),
                                productoDTO.getCiudadId()
                        );
        }

        @Test
        public void listarProductosVacios(){
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
                ProductoDTO productoDTO = new ProductoDTO(1L,"nombre",10,"titulo","descripcion","fechas","normas","seguridad","cancelacion",1l,1l);;
                Categoria categoria = new Categoria(1l,"titulo","descripcion",new Imagen());
                Ciudad ciudad = new Ciudad(1l,"nombre","pais");

                Producto producto = productoDTO.newProducto(categoria,ciudad);

                when(categoriaRepository.findById(eq(id))).thenReturn(Optional.of(categoria));
                when(ciudadRepository.findById(eq(id))).thenReturn(Optional.of(ciudad));
                when(productoRepository.findById(eq(id))).thenReturn(Optional.of(producto));
                when(productoRepository.save(ArgumentMatchers.any(Producto.class))).thenReturn(producto);

                assertThat(productoService.modificar(id, productoDTO))
                        .extracting("nombre", "calificacion", "titulo","descripcion","fechasDisponibles","normas","seguridad","cancelacion","categoria.id","ciudad.id")
                        .containsExactly(
                                productoDTO.getNombre(),
                                productoDTO.getCalificacion(),
                                productoDTO.getTitulo(),
                                productoDTO.getDescripcion(),
                                productoDTO.getFechas_disponibles(),
                                productoDTO.getNormas(),
                                productoDTO.getSeguridad(),
                                productoDTO.getCancelacion(),
                                productoDTO.getCategoriaId(),
                                productoDTO.getCiudadId()
                        );
        }

        @Test
        public void eliminarProducto(){
                final Long id = 1L;
                Producto producto= new Producto(1L,"nombre",10,"titulo","descripcion","fechas","normas","seguridad","cancelacion",new Categoria(),new Ciudad());
                when(productoRepository.findById(eq(id))).thenReturn(Optional.of(producto));
                productoService.eliminar(id);
                verify(productoRepository, times(1)).deleteById(id);
        }

        @Test
        public void agregarProductoConCategoriaQueNoExisteLanzaNotFound(){
                final Long id = 1L;
                ProductoDTO productoDTO = new ProductoDTO(1L,"nombre",10,"titulo","descripcion","fechas","normas","seguridad","cancelacion",1l,1l);
                Categoria categoria = new Categoria(1l,"titulo","descripcion",new Imagen());
                Ciudad ciudad = new Ciudad(1l,"nombre","pais");

                Producto producto = productoDTO.newProducto(categoria,ciudad);

                when(productoRepository.save(ArgumentMatchers.any(Producto.class))).thenReturn(producto);
                when(categoriaRepository.findById(eq(id))).thenReturn(Optional.empty());
                when(ciudadRepository.findById(eq(id))).thenReturn(Optional.of(ciudad));

                Assertions.assertThrows( ResponseStatusException.class, () -> productoService.guardar(productoDTO));
        }

        @Test
        public void agregarProductoConCiudadQueNoExisteLanzaNotFound(){
                final Long id = 1L;
                ProductoDTO productoDTO = new ProductoDTO(1L,"nombre",10,"titulo","descripcion","fechas","normas","seguridad","cancelacion",1l,1l);
                Categoria categoria = new Categoria(1l,"titulo","descripcion",new Imagen());
                Ciudad ciudad = new Ciudad(1l,"nombre","pais");

                Producto producto = productoDTO.newProducto(categoria,ciudad);

                when(productoRepository.save(ArgumentMatchers.any(Producto.class))).thenReturn(producto);
                when(categoriaRepository.findById(eq(id))).thenReturn(Optional.of(categoria));
                when(ciudadRepository.findById(eq(id))).thenReturn(Optional.empty());

                Assertions.assertThrows( ResponseStatusException.class, () -> productoService.guardar(productoDTO));
        }

        @Test
        public void agregarProductoConCategoriaYCiudadQueNoExistenLanzaNotFound(){
                final Long id = 1L;
                ProductoDTO productoDTO = new ProductoDTO(1L,"nombre",10,"titulo","descripcion","fechas","normas","seguridad","cancelacion",1l,1l);
                Categoria categoria = new Categoria(1l,"titulo","descripcion",new Imagen());
                Ciudad ciudad = new Ciudad(1l,"nombre","pais");

                Producto producto = productoDTO.newProducto(categoria,ciudad);

                when(productoRepository.save(ArgumentMatchers.any(Producto.class))).thenReturn(producto);
                when(categoriaRepository.findById(eq(id))).thenReturn(Optional.empty());
                when(ciudadRepository.findById(eq(id))).thenReturn(Optional.empty());

                Assertions.assertThrows( ResponseStatusException.class, () -> productoService.guardar(productoDTO));
        }


        @Test
        public void buscarProductoQueNoExisteLanzaNotFound(){
                final Long id = 1L;
                ProductoDTO productoDTO = new ProductoDTO(1L,"nombre",10,"titulo","descripcion","fechas","normas","seguridad","cancelacion",1l,1l);
                when(productoRepository.findById(id)).thenReturn(Optional.empty());

                assertThrows(ResponseStatusException.class, () -> productoService.guardar(productoDTO));
        }
*/

}
