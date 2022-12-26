package com.estudo.cadastrousuario.api.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioRequest {

    @NotBlank(message = "Nome não pode ser nulo")
    private String nome;
    private String cpf;
    private int idade;
}


