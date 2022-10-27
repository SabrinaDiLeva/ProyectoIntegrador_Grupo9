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

import static org.junit.jupiter.api.Assertions.*;
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
        String esperado = "[{\"id\":1," +
                "\"titulo\":\"Hotel\"," +
                "\"descripcion\":\"Los servicios basicos de un hotel incluyen una cama, un armario y un cuarto de banio. Suelen tener un televisor y una pequenia heladera. Otras instalaciones comunes pueden ser una psicina, un gimnasio o un restaurante.\"," +
                "\"url_imagen\":\"https://t-cf.bstatic.com/xdata/images/hotel/max1024x768/184305239.jpg?2d22fe63ae1f8960e057238c98fb436f7bd9f65854e3a5e918607c5cfa1d0a52&o=&hp=1\"" +
                "}";
        esperado += ",{\"id\":2," +
                "\"titulo\":\"Hostel\"," +
                "\"descripcion\":\"Se trata de un albergue juvenil que suele caracterizarse por el bajo precio de las habitaciones, camas o literas y por promover el intercambio cultural y social entre los huespedes.\"," +
                "\"url_imagen\":\"https://q-xx.bstatic.com/xdata/images/hotel/max1024x768/144249450.jpg?k=125620f12083864434f01ddf9015267929594204e1b0900bb400db48363089e780=\"" +
                "}";
        esperado += ",{\"id\":3,\"titulo\":\"Bed and breakfast\",\"descripcion\":\"Un bed and breakfast es un tipo de alojamiento en una residencia privada de pocas habitaciones, que ofrece un desayuno. Se caracterizan por un ambiente familiar y hogarenio, es usual que los duenios de los B&B vivan en el mismo inmueble.\",\"url_imagen\":\"https://hotelpropeller.com/wp-content/uploads/2013/04/Bed-and-Breakfast-Facebook-Page.jpg\"}";
        esperado += ",{\"id\":4," +
                "\"titulo\":\"Casa/Departamento\"," +
                "\"descripcion\":\"Sin descripcion.\"," +
                "\"url_imagen\":\"https://t-cf.bstatic.com/xdata/images/hotel/max1024x768/184305239.jpg?2d22fe63ae1f8960e057238c98fb436f7bd9f65854e3a5e918607c5cfa1d0a52&o=&hp=1\"" +
                "}]";

        Assertions.assertEquals(esperado, categoria3);

    }
    @Test
    void test02obtenerCategoriaConIdTres() throws Exception {
        MvcResult respuesta = this.mockMvc.perform(MockMvcRequestBuilders.get("/categoria/3")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print()).andExpect(status().isOk()).andReturn();

        String categoria3 = respuesta.getResponse().getContentAsString();
        String esperado = "{\"id\":3,\"titulo\":\"Bed and breakfast\",\"descripcion\":\"Un bed and breakfast es un tipo de alojamiento en una residencia privada de pocas habitaciones, que ofrece un desayuno. Se caracterizan por un ambiente familiar y hogarenio, es usual que los duenios de los B&B vivan en el mismo inmueble.\",\"url_imagen\":\"https://hotelpropeller.com/wp-content/uploads/2013/04/Bed-and-Breakfast-Facebook-Page.jpg\"}";
        Assertions.assertEquals(esperado, categoria3);

    }
    @Test
    void test03agregarNuevaCategoria() throws Exception {
        String jsonPost = "{\n" +
                "    \"titulo\" : \"Categoria de prueba\",\n" +
                "    \"descripcion\" : \"Sin descripcion\",\n" +
                "    \"url_imagen\" : \"Sin URL\"\n" +
                "}";

        this.mockMvc.perform(MockMvcRequestBuilders.post("/categoria")
                        .contentType(MediaType.APPLICATION_JSON).content(jsonPost))
                .andDo(MockMvcResultHandlers.print()).andExpect(status().isOk()).andReturn();

        MvcResult respuesta = this.mockMvc.perform(MockMvcRequestBuilders.get("/categoria/5")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print()).andExpect(status().isOk()).andReturn();

        String categoria3 = respuesta.getResponse().getContentAsString();
        String esperado = "{\"id\":5,\"titulo\":\"Categoria de prueba\",\"descripcion\":\"Sin descripcion\",\"url_imagen\":\"Sin URL\"}";
        Assertions.assertEquals(esperado, categoria3);
    }
    @Test
    void test04eliminarCategoria() throws Exception {
        MvcResult respuesta = this.mockMvc.perform(MockMvcRequestBuilders.delete("/categoria/5")
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
        String jsonPost= "{\n" +
                "\t\"id\":4,\n" +
                "\t\"titulo\":\"Casa/Departamento\",\n" +
                "\t\"descripcion\":\"A definir por el duenio.\",\n" +
                "\t\"url_imagen\":\"https://t-cf.bstatic.com/xdata/images/hotel/max1024x768/184305239.jpg?2d22fe63ae1f8960e057238c98fb436f7bd9f65854e3a5e918607c5cfa1d0a52&o=&hp=1\"\n" +
                "}";

        MvcResult respuesta = this.mockMvc.perform(MockMvcRequestBuilders.put("/categoria/4")
                        .contentType(MediaType.APPLICATION_JSON).content(jsonPost))
                .andDo(MockMvcResultHandlers.print()).andExpect(status().isOk()).andReturn();

        String categoria4 = respuesta.getResponse().getContentAsString();
        String esperado = "{\"id\":4," +
                "\"titulo\":\"Casa/Departamento\"," +
                "\"descripcion\":\"A definir por el duenio.\"," +
                "\"url_imagen\":\"https://t-cf.bstatic.com/xdata/images/hotel/max1024x768/184305239.jpg?2d22fe63ae1f8960e057238c98fb436f7bd9f65854e3a5e918607c5cfa1d0a52&o=&hp=1\"" +
                "}";

        Assertions.assertEquals(esperado, categoria4);
    }
    @Test
    void test07actualizarCategoriaInexistente() throws Exception {
        String jsonPost= "{\n" +
                "\t\"id\":5,\n" +
                "\t\"titulo\":\"Casa/Departamento\",\n" +
                "\t\"descripcion\":\"A definir por el duenio.\",\n" +
                "\t\"url_imagen\":\"https://t-cf.bstatic.com/xdata/images/hotel/max1024x768/184305239.jpg?2d22fe63ae1f8960e057238c98fb436f7bd9f65854e3a5e918607c5cfa1d0a52&o=&hp=1\"\n" +
                "}";

        this.mockMvc.perform(MockMvcRequestBuilders.put("/categoria/5")
                        .contentType(MediaType.APPLICATION_JSON).content(jsonPost))
                .andDo(MockMvcResultHandlers.print()).andExpect(status().isNotFound()).andReturn();
    }
    @Test
    void test08eliminarrCategoriaInexistente() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/categoria/5")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print()).andExpect(status().isNotFound()).andReturn();
    }
    private void agregarTodasLasCategorias() throws Exception {
        String jsonPost = "{\n" +
                "    \"titulo\" : \"Hotel\",\n" +
                "    \"descripcion\" : \"Los servicios basicos de un hotel incluyen una cama, un armario y un cuarto de banio. Suelen tener un televisor y una pequenia heladera. Otras instalaciones comunes pueden ser una psicina, un gimnasio o un restaurante.\",\n" +
                "    \"url_imagen\" : \"https://t-cf.bstatic.com/xdata/images/hotel/max1024x768/184305239.jpg?2d22fe63ae1f8960e057238c98fb436f7bd9f65854e3a5e918607c5cfa1d0a52&o=&hp=1\"\n" +
                "}";

        this.mockMvc.perform(MockMvcRequestBuilders.post("/categoria")
                        .contentType(MediaType.APPLICATION_JSON).content(jsonPost))
                .andDo(MockMvcResultHandlers.print()).andReturn();

        jsonPost = "{\n" +
                "    \"titulo\" : \"Hostel\",\n" +
                "    \"descripcion\" : \"Se trata de un albergue juvenil que suele caracterizarse por el bajo precio de las habitaciones, camas o literas y por promover el intercambio cultural y social entre los huespedes.\",\n" +
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
        this.agregarTodasLasCategorias();
    }

}