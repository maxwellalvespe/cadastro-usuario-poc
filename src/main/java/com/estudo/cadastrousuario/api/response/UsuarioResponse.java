package com.estudo.cadastrousuario.api.response;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioResponse {

    private int id;
    private String nome;
    private String cpf;
    private int idade;
}
