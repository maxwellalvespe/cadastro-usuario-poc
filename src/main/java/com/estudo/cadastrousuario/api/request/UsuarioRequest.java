package com.estudo.cadastrousuario.api.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioRequest {

    @NotBlank(message = "Nome não pode ser nulo")
    private String nome;
    private String cpf;
    @Min(value = 18,message = "Idade não pode ser inferior a 18 anos")
    private int idade;
}


