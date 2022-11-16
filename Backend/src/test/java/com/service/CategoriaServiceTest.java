// package com.service;

// import com.dto.command.CategoriaDTO;
// import com.model.Categoria;
// import com.model.Imagen;
// import com.model.Producto;
// import com.repository.ICategoriaRepository;
// import com.repository.IImagenRepository;
// import org.junit.jupiter.api.*;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.web.server.ResponseStatusException;

// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.List;
// import java.util.Optional;

// import static org.assertj.core.api.Assertions.assertThat;
// import static org.junit.jupiter.api.Assertions.*;
// import static org.mockito.ArgumentMatchers.any;
// import static org.mockito.Mockito.*;

// @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
// @SpringBootTest
// public class CategoriaServiceTest {
//     @Mock
//     ICategoriaRepository categoriaRepository;
//     @Mock
//     IImagenRepository imagenRepository;
//     @InjectMocks
//     private CategoriaService categoriaService;

//     @Test
//     public void agregarCategoria(){
//         CategoriaDTO categoriaDTO = new CategoriaDTO( 1L, "titulo","descripcion", 1L);
//         Imagen img = new Imagen(1L, "titulo", "url");
//         Categoria categoria = categoriaDTO.newCategoria(img);
//         when(categoriaRepository.save(any(Categoria.class))).thenReturn(categoria);
//         when(imagenRepository.findById(1L)).thenReturn(Optional.of(img));

//         assertThat(categoriaService.guardar(categoriaDTO))
//                 .extracting("titulo", "descripcion", "imagen.id")
//                 .containsExactly(
//                         categoriaDTO.getTitulo(),
//                         categoriaDTO.getDescripcion(),
//                         categoriaDTO.getImagenId()
//                 );
//     }

//     @Test
//     public void listarCategorias(){
//         CategoriaDTO[] categorias = {new CategoriaDTO(1l,"test", "test", 1L), new CategoriaDTO(2l,"test", "test", 2L)};
//         List<CategoriaDTO> lista = new ArrayList<>(Arrays.asList(categorias));
//         List<Categoria> lista_categorias = lista.stream().map(c -> c.newCategoria(new Imagen(c.getImagenId(), "titulo", "url"))).toList();
//         when(categoriaRepository.findAll()).thenReturn(lista_categorias);
//         List<Categoria> lista_c = categoriaService.listar();
//         assertThat(lista_c).hasSizeGreaterThan(0)
//                 .hasSameElementsAs(lista_categorias);
//     }

//     @Test
//     public void buscarCategoria(){
//         final Long id = 1L;
//         CategoriaDTO categoriaDTO = new CategoriaDTO( id, "titulo","descripcion", id);
//         Imagen img = new Imagen(id, "titulo", "url" );
//         Categoria categoria = categoriaDTO.newCategoria(img);
//         when(imagenRepository.findById(eq(id))).thenReturn(Optional.of(img));
//         when(categoriaRepository.findById(id)).thenReturn(Optional.of(categoria));
//         when(categoriaRepository.save(any(Categoria.class))).thenReturn(categoria);

//         assertThat(categoriaService.guardar(categoriaDTO))
//                 .extracting("titulo", "descripcion", "imagen.id")
//                 .containsExactly(
//                         categoriaDTO.getTitulo(),
//                         categoriaDTO.getDescripcion(),
//                         categoriaDTO.getImagenId()
//                 );
//     }

//     @Test
//     public void listarCategoriasVacias(){
//         List<Categoria> lista_categorias = new ArrayList<>();
//         when(categoriaRepository.findAll()).thenReturn(lista_categorias);
//         List<Categoria> lista = categoriaService.listar();
//         assertThat(lista)
//                 .hasSize(0)
//                 .hasSameElementsAs(lista_categorias);
//     }
//     @Test
//     public void actualizarCategoria(){
//         final Long id = 1L;
//         CategoriaDTO categoriaDTO = new CategoriaDTO(id, "Casa en la montaña", "Un casa linda", id);
//         Imagen img = new Imagen(id, "titulo", "url");
//         Categoria categoria = categoriaDTO.newCategoria(img);

//         when(imagenRepository.findById(eq(id))).thenReturn(Optional.of(img));
//         when(categoriaRepository.findById(eq(id))).thenReturn(Optional.of(categoria));
//         when(categoriaRepository.save(any(Categoria.class))).thenReturn(categoria);

//         assertThat(categoriaService.modificar(id, categoriaDTO))
//             .extracting("titulo", "descripcion", "imagen.id")
//             .containsExactly(
//                 categoriaDTO.getTitulo(),
//                 categoriaDTO.getDescripcion(),
//                 categoriaDTO.getImagenId()
//             );
//     }

//     @Test
//     public void eliminarCategoria(){
//         final Long id = 1L;
//         Categoria categoria = new Categoria(id, "Casa en la montaña", "Un casa linda", new Imagen(id, "titulo", "url"));
//         when(categoriaRepository.findById(eq(id))).thenReturn(Optional.of(categoria));
//         categoriaService.eliminar(id);
//         verify(categoriaRepository, times(1)).deleteById(id);
//     }
//     @Test
//     public void agregarCategoriaConUnaImagenConProductoAsociadoLanzaBadRequest(){
//         final Long id = 1L;
//         CategoriaDTO categoriaDTO = new CategoriaDTO( 1L, "titulo","descripcion", id);
//         Imagen img = new Imagen(id, "titulo", "url", new Producto());
//         Categoria categoria = categoriaDTO.newCategoria(img);
//         when(categoriaRepository.save(any(Categoria.class))).thenReturn(categoria);
//         when(imagenRepository.findById(eq(id))).thenReturn(Optional.of(img));

//         Assertions.assertThrows( ResponseStatusException.class, () -> categoriaService.guardar(categoriaDTO));
//     }
//     @Test
//     public void agregarCategoriaConImagenQueNoExisteLanzaNotFound(){
//         final Long id = 1L;
//         CategoriaDTO categoriaDTO = new CategoriaDTO( 1L, "titulo","descripcion", id);
//         Imagen img = new Imagen(id, "titulo", "url", new Producto());
//         Categoria categoria = categoriaDTO.newCategoria(img);
//         when(categoriaRepository.save(any(Categoria.class))).thenReturn(categoria);
//         when(imagenRepository.findById(eq(id))).thenReturn(Optional.empty());

//         Assertions.assertThrows( ResponseStatusException.class, () -> categoriaService.guardar(categoriaDTO));
//     }

//     @Test
//     public void buscarCategoriaQueNoExisteLanzaNotFound(){
//         final Long id = 1L;
//         CategoriaDTO categoriaDTO = new CategoriaDTO( 1L, "titulo","descripcion", id);
//         when(categoriaRepository.findById(id)).thenReturn(Optional.empty());

//         assertThrows(ResponseStatusException.class, () -> categoriaService.guardar(categoriaDTO));
//     }
// }
