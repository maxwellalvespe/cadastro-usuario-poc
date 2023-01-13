package com.estudo.cadastrousuario.api.resource;

import com.estudo.cadastrousuario.Application;
import com.estudo.cadastrousuario.api.response.UsuarioResponse;
import com.estudo.cadastrousuario.domain.Usuario;
import com.estudo.cadastrousuario.repository.UsuarioRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.yaml.snakeyaml.util.ArrayUtils;

import static net.bytebuddy.matcher.ElementMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = Application.class)
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application-dev.properties")
class UsuarioResourcesTest {

    private final String RESOURCE_USERS = "/usuarios";
    @Autowired
    private MockMvc mvc;
    @Autowired
    private UsuarioRepository repository;

    @BeforeEach
    void startSetup() {
        repository.save(new Usuario(null, "max", "123", 18));
    }

    @AfterEach
    void endSetup() {
        repository.deleteAll();
    }

    @Test
    @DisplayName("deve retornar um usuários cadastrado na base de dados.")
    void consultaUsuarioExistente() throws Exception {

        var response = "[{\"id\":1,\"nome\":\"max\",\"cpf\":\"123\",\"idade\":18}]";

        var responseApi =  mvc.perform(get(RESOURCE_USERS)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().json(response));

    }

}