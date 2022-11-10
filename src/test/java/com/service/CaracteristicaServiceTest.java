package com.service;

import com.dto.command.CaracteristicaDTO;
import com.dto.command.CategoriaDTO;
import com.model.Caracteristica;
import com.model.Categoria;
import com.model.Imagen;
import com.model.Producto;
import com.repository.ICaracteristicaRepository;
import com.repository.ICategoriaRepository;
import com.repository.IImagenRepository;
import com.service.CategoriaService;
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
public class CaracteristicaServiceTest {
    @Mock
    ICaracteristicaRepository caracterisicaRepository;
    @InjectMocks
    private CaracteristicaService caracteristicaService;

    @Test
    public void agregarCaracteristica(){
        CaracteristicaDTO caracteristicaDTO = new CaracteristicaDTO( 1L, "nombre","descripcion");
        Caracteristica caracteristica = caracteristicaDTO.newCaracteristica();
        when(caracterisicaRepository.save(any(Caracteristica.class))).thenReturn(caracteristica);

        assertThat(caracteristicaService.guardar(caracteristicaDTO))
                .extracting("nombre", "descripcion")
                .containsExactly(
                        caracteristicaDTO.getNombre(),
                        caracteristicaDTO.getDescripcion()
                );
    }

    @Test
    public void listarCaracteristicas(){
        CaracteristicaDTO[] caracteristicas = {new CaracteristicaDTO(1l,"test", "test"), new CaracteristicaDTO(2l,"test", "test")};
        List<CaracteristicaDTO> lista = new ArrayList<>(Arrays.asList(caracteristicas));
        List<Caracteristica> lista_caracteristicas = lista.stream().map(c -> c.newCaracteristica()).toList();
        when(caracterisicaRepository.findAll()).thenReturn(lista_caracteristicas);
        List<Caracteristica> lista_c = caracteristicaService.listar();
        assertThat(lista_c).hasSizeGreaterThan(0)
                .hasSameElementsAs(lista_caracteristicas);
    }

    @Test
    public void buscarCaracteristica(){
        final Long id = 1L;
        CaracteristicaDTO caracteristicaDTO = new CaracteristicaDTO( id, "titulo","descripcion");
        Caracteristica caracteristica = caracteristicaDTO.newCaracteristica();
        when(caracterisicaRepository.findById(id)).thenReturn(Optional.of(caracteristica));
        when(caracterisicaRepository.save(any(Caracteristica.class))).thenReturn(caracteristica);

        assertThat(caracteristicaService.guardar(caracteristicaDTO))
                .extracting("titulo", "descripcion")
                .containsExactly(
                        caracteristicaDTO.getNombre(),
                        caracteristicaDTO.getDescripcion()
                );
    }

    @Test
    public void listarCaracteristicasVacias(){
        List<Caracteristica> lista_caracteristicas = new ArrayList<>();
        when(caracterisicaRepository.findAll()).thenReturn(lista_caracteristicas);
        List<Caracteristica> lista = caracteristicaService.listar();
        assertThat(lista)
                .hasSize(0)
                .hasSameElementsAs(lista_caracteristicas);
    }
    @Test
    public void actualizarCaracteristica(){
        final Long id = 1L;
        CaracteristicaDTO caracteristicaDTO = new CaracteristicaDTO(id, "Aire acondicionado", "Aire frio en la habitacion");
        Caracteristica caracteristica = caracteristicaDTO.newCaracteristica();

        when(caracterisicaRepository.findById(eq(id))).thenReturn(Optional.of(caracteristica));
        when(caracterisicaRepository.save(any(Caracteristica.class))).thenReturn(caracteristica);

        assertThat(caracteristicaService.modificar(id, caracteristicaDTO))
                .extracting("titulo", "descripcion")
                .containsExactly(
                        caracteristicaDTO.getNombre(),
                        caracteristicaDTO.getDescripcion()
                );
    }

    @Test
    public void eliminarCaracteristica(){
        final Long id = 1L;
        Caracteristica caracteristica = new Caracteristica(id, "Aire acondicionado", "Aire frio en la habitacion");
        when(caracterisicaRepository.findById(eq(id))).thenReturn(Optional.of(caracteristica));
        caracteristicaService.eliminar(id);
        verify(caracterisicaRepository, times(1)).deleteById(id);
    }


    @Test
    public void buscarCaracteristicaQueNoExisteLanzaNotFound(){
        final Long id = 1L;
        CaracteristicaDTO caracteristicaDTO = new CaracteristicaDTO( 1L, "titulo","descripcion");
        when(caracterisicaRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(ResponseStatusException.class, () -> caracteristicaService.guardar(caracteristicaDTO));
    }
}