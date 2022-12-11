// package com.service;


// import com.dto.command.CiudadDTO;
// import com.model.Ciudad;
// import com.repository.ICiudadRepository;
// import org.junit.jupiter.api.MethodOrderer;
// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.TestMethodOrder;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.web.server.ResponseStatusException;

// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.List;
// import java.util.Optional;

// import static org.assertj.core.api.Assertions.assertThat;
// import static org.junit.jupiter.api.Assertions.assertThrows;
// import static org.mockito.ArgumentMatchers.any;
// import static org.mockito.ArgumentMatchers.eq;
// import static org.mockito.Mockito.*;
// import static org.mockito.Mockito.when;

// @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
// @SpringBootTest
// public class CiudadServiceTest {
//     @Mock
//     ICiudadRepository ciudadRepository;
//     @InjectMocks
//     private CiudadService ciudadService;

//     @Test
//     public void agregarCiudad(){
//         CiudadDTO ciudadDTO = new CiudadDTO( 1L, "nombre","pais");
//         Ciudad ciudad = ciudadDTO.newCiudad();
//         when(ciudadRepository.save(any(Ciudad.class))).thenReturn(ciudad);

//         assertThat(ciudadService.guardar(ciudadDTO))
//                 .extracting("nombre", "pais")
//                 .containsExactly(
//                         ciudadDTO.getNombre(),
//                         ciudadDTO.getPais()
//                 );
//     }

//     @Test
//     public void listarCiudad(){
//         CiudadDTO[] ciudades = {new CiudadDTO(1l,"test", "test"), new CiudadDTO(2l,"test", "test")};
//         List<CiudadDTO> lista = new ArrayList<>(Arrays.asList(ciudades));
//         List<Ciudad> lista_ciudades = lista.stream().map(c -> c.newCiudad()).toList();
//         when(ciudadRepository.findAll()).thenReturn(lista_ciudades);
//         List<Ciudad> lista_c = ciudadService.listar();
//         assertThat(lista_c).hasSizeGreaterThan(0)
//                 .hasSameElementsAs(lista_ciudades);
//     }

//     @Test
//     public void buscarCiudad(){
//         final Long id = 1L;
//         CiudadDTO ciudadDTO = new CiudadDTO( id, "nombre","pais");
//         Ciudad ciudad = ciudadDTO.newCiudad();
//         when(ciudadRepository.findById(id)).thenReturn(Optional.of(ciudad));
//         when(ciudadRepository.save(any(Ciudad.class))).thenReturn(ciudad);

//         assertThat(ciudadService.guardar(ciudadDTO))
//                 .extracting("nombre", "pais")
//                 .containsExactly(
//                         ciudadDTO.getNombre(),
//                         ciudadDTO.getPais()
//                 );
//     }

//     @Test
//     public void listarCiudadesVacias(){
//         List<Ciudad> lista_ciudades = new ArrayList<>();
//         when(ciudadRepository.findAll()).thenReturn(lista_ciudades);
//         List<Ciudad> lista = ciudadService.listar();
//         assertThat(lista)
//                 .hasSize(0)
//                 .hasSameElementsAs(lista_ciudades);
//     }
//     @Test
//     public void actualizarCiudad(){
//         final Long id = 1L;
//         CiudadDTO ciudadDTO = new CiudadDTO(id, "Buenos Aires", "Argentina");
//         Ciudad ciudad = ciudadDTO.newCiudad();

//         when(ciudadRepository.findById(eq(id))).thenReturn(Optional.of(ciudad));
//         when(ciudadRepository.save(any(Ciudad.class))).thenReturn(ciudad);

//         assertThat(ciudadService.modificar(id, ciudadDTO))
//                 .extracting("titulo", "descripcion")
//                 .containsExactly(
//                         ciudadDTO.getNombre(),
//                         ciudadDTO.getPais()
//                 );
//     }

//     @Test
//     public void eliminarCiudad(){
//         final Long id = 1L;
//         Ciudad ciudad = new Ciudad(id, "Buenos Aires", "Argentina");
//         when(ciudadRepository.findById(eq(id))).thenReturn(Optional.of(ciudad));
//         ciudadService.eliminar(id);
//         verify(ciudadRepository, times(1)).deleteById(id);
//     }


//     @Test
//     public void buscarCiudadQueNoExisteLanzaNotFound(){
//         final Long id = 1L;
//         CiudadDTO ciudadDTO = new CiudadDTO( 1L, "nombre","pais");
//         when(ciudadRepository.findById(id)).thenReturn(Optional.empty());

//         assertThrows(ResponseStatusException.class, () -> ciudadService.guardar(ciudadDTO));
//     }
// }
