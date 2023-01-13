package com.estudo.cadastrousuario;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
@OpenAPIDefinition(info = @Info(title = "Votação API",
        version = "0.0.1"))
public class Application {

        public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
