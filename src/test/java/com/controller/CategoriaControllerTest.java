package com.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CategoriaControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void test01obtenerCategoriaConIdTres() throws Exception {
        MvcResult respuesta = this.mockMvc.perform(MockMvcRequestBuilders.get("/categoria/3")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print()).andReturn();

        Integer estadoGet = respuesta.getResponse().getStatus();
        Integer  estadoEsperado = 200;

        Assertions.assertEquals(estadoEsperado, estadoGet);

        String categoria3 = respuesta.getResponse().getContentAsString();
        String esperado = "{\"id\":3,\"titulo\":\"Bed and breakfast\",\"descripcion\":\"Un bed and breakfast es un tipo de alojamiento en una residencia privada de pocas habitaciones, que ofrece un desayuno. Se caracterizan por un ambiente familiar y hogarenio, es usual que los duenios de los B&B vivan en el mismo inmueble.\",\"url_imagen\":\"https://hotelpropeller.com/wp-content/uploads/2013/04/Bed-and-Breakfast-Facebook-Page.jpg\"}";
        Assertions.assertEquals(esperado, categoria3);

    }
    @Test
    void test02agregarNuevaCategoria() throws Exception {
        String jsonPost = "{\n" +
                "    \"titulo\" : \"Super Hotel\",\n" +
                "    \"descripcion\" : \"Nuevo Hotel.\",\n" +
                "    \"url_imagen\" : \"imagen_test\"\n" +
                "}";

        MvcResult respuesta = this.mockMvc.perform(MockMvcRequestBuilders.post("/categoria")
                        .contentType(MediaType.APPLICATION_JSON).content(jsonPost))
                .andDo(MockMvcResultHandlers.print()).andReturn();

        Integer estadoGet = respuesta.getResponse().getStatus();
        Integer  estadoEsperado = 200;

        Assertions.assertEquals(estadoEsperado, estadoGet);

        respuesta = this.mockMvc.perform(MockMvcRequestBuilders.get("/categoria/5")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print()).andReturn();

        estadoGet = respuesta.getResponse().getStatus();
        Assertions.assertEquals(estadoEsperado, estadoGet);

        String categoria3 = respuesta.getResponse().getContentAsString();
        String esperado = "{\"id\":5,\"titulo\":\"Super Hotel\",\"descripcion\":\"Nuevo Hotel.\",\"url_imagen\":\"imagen_test\"}";
        Assertions.assertEquals(esperado, categoria3);
    }
    private void agregarCategoria() throws Exception {
        String jsonPost = "{\n" +
                "    \"titulo\" : \"Hotel\",\n" +
                "    \"descripcion\" : \"Los servicios básicos de un hotel incluyen una cama, un armario y un cuarto de banio. Suelen tener un televisor y una pequenia heladera. Otras instalaciones comunes pueden ser una psicina, un gimnasio o un restaurante.\",\n" +
                "    \"url_imagen\" : \"https://t-cf.bstatic.com/xdata/images/hotel/max1024x768/184305239.jpg?2d22fe63ae1f8960e057238c98fb436f7bd9f65854e3a5e918607c5cfa1d0a52&o=&hp=1\"\n" +
                "}";

        this.mockMvc.perform(MockMvcRequestBuilders.post("/categoria")
                        .contentType(MediaType.APPLICATION_JSON).content(jsonPost))
                .andDo(MockMvcResultHandlers.print()).andReturn();

        jsonPost = "{\n" +
                "    \"titulo\" : \"Hostel\",\n" +
                "    \"descripcion\" : \"Se trata de un albergue juvenil que suele caracterizarse por el bajo precio de las habitaciones, camas o literas y por promover el intercambio cultural y social entre los huéspedes.\",\n" +
                "    \"url_imagen\" : \"https://q-xx.bstatic.com/xdata/images/hotel/max1024x768/144249450.jpg?k=125620f12083864434f01ddf9015267929594204e1b0900bb400db48363089e780=\"\n" +
                "}";

        this.mockMvc.perform(MockMvcRequestBuilders.post("/categoria")
                        .contentType(MediaType.APPLICATION_JSON).content(jsonPost))
                .andDo(MockMvcResultHandlers.print()).andReturn();

        jsonPost = "{\n" +
                "    \"titulo\" : \"Bed and breakfast\",\n" +
                "    \"descripcion\" : \"Un bed and breakfast es un tipo de alojamiento en una residencia privada de pocas habitaciones, que ofrece un desayuno. Se caracterizan por un ambiente familiar y hogarenio, es usual que los duenios de los B&B vivan en el mismo inmueble.\",\n" +
                "    \"url_imagen\" : \"https://hotelpropeller.com/wp-content/uploads/2013/04/Bed-and-Breakfast-Facebook-Page.jpg\"\n" +
                "}";

        this.mockMvc.perform(MockMvcRequestBuilders.post("/categoria")
                        .contentType(MediaType.APPLICATION_JSON).content(jsonPost))
                .andDo(MockMvcResultHandlers.print()).andReturn();

        jsonPost = "{\n" +
                "    \"titulo\" : \"Casa/Departamento\",\n" +
                "    \"descripcion\" : \"Sin descripcion.\",\n" +
                "    \"url_imagen\" : \"https://t-cf.bstatic.com/xdata/images/hotel/max1024x768/184305239.jpg?2d22fe63ae1f8960e057238c98fb436f7bd9f65854e3a5e918607c5cfa1d0a52&o=&hp=1\"\n" +
                "}";

        this.mockMvc.perform(MockMvcRequestBuilders.post("/categoria")
                        .contentType(MediaType.APPLICATION_JSON).content(jsonPost))
                .andDo(MockMvcResultHandlers.print()).andReturn();
    }

    @BeforeAll
    void beforeAllTestAgregarCuatroCategorias() throws Exception {
        this.agregarCategoria();
    }
}