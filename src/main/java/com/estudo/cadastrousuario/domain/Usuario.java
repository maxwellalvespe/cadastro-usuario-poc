package com.estudo.cadastrousuario.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    private int id = new AtomicInteger().getAndIncrement();
    private String nome;
    private String cpf;
    private int idade;

}
