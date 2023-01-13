package com.estudo.cadastrousuario.api.response;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class UsuarioResponse implements Serializable {

    private int id;
    private String nome;
    private String cpf;
    private int idade;
}
