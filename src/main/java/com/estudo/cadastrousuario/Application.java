package com.estudo.cadastrousuario;

import com.estudo.cadastrousuario.domain.Enquete;
import com.estudo.cadastrousuario.domain.Usuario;
import com.estudo.cadastrousuario.domain.Votacao;
import com.estudo.cadastrousuario.domain.enums.Voto;
import com.estudo.cadastrousuario.repository.EnqueteRepository;
import com.estudo.cadastrousuario.repository.UsuarioRepository;
import com.estudo.cadastrousuario.repository.VotacaoRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
@RequiredArgsConstructor
//@OpenAPIDefinition(info = @Info(title = "Votação API",
//        version = "2.0"))
public class Application {

        public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
