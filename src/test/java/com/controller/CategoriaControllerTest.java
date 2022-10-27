package com.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.Categoria;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
@TestMethodOrder(MethodOrderer.MethodName.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CategoriaControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void test01buscarTodasLasCategorias() throws Exception {
        MvcResult respuesta = this.mockMvc.perform(MockMvcRequestBuilders.get("/categoria/")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk()).andReturn();

        String categoria3 = respuesta.getResponse().getContentAsString();
        List<Categoria> lista = new ArrayList<>();
        lista.add(new Categoria(1l, "Hotel","Los servicios basicos de un hotel incluyen una cama, un armario y un cuarto de banio. Suelen tener un televisor y una pequenia heladera. Otras instalaciones comunes pueden ser una psicina, un gimnasio o un restaurante.","https://t-cf.bstatic.com/xdata/images/hotel/max1024x768/184305239.jpg?2d22fe63ae1f8960e057238c98fb436f7bd9f65854e3a5e918607c5cfa1d0a52&o=&hp=1"));
        lista.add(new Categoria(2l, "Hostel","Se trata de un albergue juvenil que suele caracterizarse por el bajo precio de las habitaciones, camas o literas y por promover el intercambio cultural y social entre los huespedes.","https://q-xx.bstatic.com/xdata/images/hotel/max1024x768/144249450.jpg?k=125620f12083864434f01ddf9015267929594204e1b0900bb400db48363089e780="));
        lista.add(new Categoria(3l, "Bed and breakfast","Un bed and breakfast es un tipo de alojamiento en una residencia privada de pocas habitaciones, que ofrece un desayuno. Se caracterizan por un ambiente familiar y hogarenio, es usual que los duenios de los B&B vivan en el mismo inmueble.","https://hotelpropeller.com/wp-content/uploads/2013/04/Bed-and-Breakfast-Facebook-Page.jpg"));
        lista.add(new Categoria(4l, "Casa/Departamento", "Sin descripcion.","https://t-cf.bstatic.com/xdata/images/hotel/max1024x768/184305239.jpg?2d22fe63ae1f8960e057238c98fb436f7bd9f65854e3a5e918607c5cfa1d0a52&o=&hp=1"));
        String esperado = asJsonString(lista);

        Assertions.assertEquals(esperado, categoria3);

    }
    @Test
    void test02obtenerCategoriaConIdTres() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/categoria/{id}",3l )
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.titulo").value("Bed and breakfast"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.descripcion").value("Un bed and breakfast es un tipo de alojamiento en una residencia privada de pocas habitaciones, que ofrece un desayuno. Se caracterizan por un ambiente familiar y hogarenio, es usual que los duenios de los B&B vivan en el mismo inmueble."))
                .andExpect(MockMvcResultMatchers.jsonPath("$.url_imagen").value("https://hotelpropeller.com/wp-content/uploads/2013/04/Bed-and-Breakfast-Facebook-Page.jpg"));;
    }
    @Test
    void test03agregarNuevaCategoria() throws Exception {
        this.mockMvc.perform( MockMvcRequestBuilders
                        .post("/categoria/" )
                        .content(asJsonString(new Categoria(null, "Categoria de prueba", "Sin descripcion", "Sin URL")))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.titulo").value("Categoria de prueba"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.descripcion").value("Sin descripcion"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.url_imagen").value("Sin URL"));;
    }
    @Test
    void test04eliminarCategoria() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/categoria/5")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print()).andExpect(status().isOk()).andReturn();
    }
    @Test
    void test05obtenerCategoriaEliminada() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/categoria/5")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isNotFound()).andReturn();

    }
    @Test
    void test06actualizarCategoria() throws Exception {
        this.mockMvc.perform( MockMvcRequestBuilders
                        .put("/categoria/{id}",4l )
                        .content(asJsonString(new Categoria(4l, "Casa/Departamento", "A definir por el duenio.","https://t-cf.bstatic.com/xdata/images/hotel/max1024x768/184305239.jpg?2d22fe63ae1f8960e057238c98fb436f7bd9f65854e3a5e918607c5cfa1d0a52&o=&hp=1")))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.titulo").value("Casa/Departamento"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.descripcion").value("A definir por el duenio."))
                .andExpect(MockMvcResultMatchers.jsonPath("$.url_imagen").value("https://t-cf.bstatic.com/xdata/images/hotel/max1024x768/184305239.jpg?2d22fe63ae1f8960e057238c98fb436f7bd9f65854e3a5e918607c5cfa1d0a52&o=&hp=1"));
    }
    @Test
    void test07actualizarCategoriaInexistente() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.put("/categoria/5")
                        .content(asJsonString(new Categoria(5l, "Casa/Departamento", "A definir por el duenio.","https://t-cf.bstatic.com/xdata/images/hotel/max1024x768/184305239.jpg?2d22fe63ae1f8960e057238c98fb436f7bd9f65854e3a5e918607c5cfa1d0a52&o=&hp=1")))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound()).andReturn();
    }
    @Test
    void test08eliminarrCategoriaInexistente() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/categoria/5")
                        .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound()).andReturn();
    }
    private void agregarTodasLasCategorias() throws Exception {
        List<Categoria> lista = new ArrayList<>();
        lista.add(new Categoria(null, "Hotel","Los servicios basicos de un hotel incluyen una cama, un armario y un cuarto de banio. Suelen tener un televisor y una pequenia heladera. Otras instalaciones comunes pueden ser una psicina, un gimnasio o un restaurante.","https://t-cf.bstatic.com/xdata/images/hotel/max1024x768/184305239.jpg?2d22fe63ae1f8960e057238c98fb436f7bd9f65854e3a5e918607c5cfa1d0a52&o=&hp=1"));
        lista.add(new Categoria(null, "Hostel","Se trata de un albergue juvenil que suele caracterizarse por el bajo precio de las habitaciones, camas o literas y por promover el intercambio cultural y social entre los huespedes.","https://q-xx.bstatic.com/xdata/images/hotel/max1024x768/144249450.jpg?k=125620f12083864434f01ddf9015267929594204e1b0900bb400db48363089e780="));
        lista.add(new Categoria(null, "Bed and breakfast","Un bed and breakfast es un tipo de alojamiento en una residencia privada de pocas habitaciones, que ofrece un desayuno. Se caracterizan por un ambiente familiar y hogarenio, es usual que los duenios de los B&B vivan en el mismo inmueble.","https://hotelpropeller.com/wp-content/uploads/2013/04/Bed-and-Breakfast-Facebook-Page.jpg"));
        lista.add(new Categoria(null, "Casa/Departamento", "Sin descripcion.","https://t-cf.bstatic.com/xdata/images/hotel/max1024x768/184305239.jpg?2d22fe63ae1f8960e057238c98fb436f7bd9f65854e3a5e918607c5cfa1d0a52&o=&hp=1"));

        for ( Categoria categoria: lista)
            this.mockMvc.perform(MockMvcRequestBuilders.post("/categoria")
                            .content(asJsonString(categoria))
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());


    }

    @BeforeAll
    void beforeAllTestAgregarCuatroCategorias() throws Exception {
        this.agregarTodasLasCategorias();
    }
    public static String asJsonString(final Object obj) {
       try {
            return new ObjectMapper().writeValueAsString(obj);
       } catch (Exception e) {
            throw new RuntimeException(e);
       }
    }

}