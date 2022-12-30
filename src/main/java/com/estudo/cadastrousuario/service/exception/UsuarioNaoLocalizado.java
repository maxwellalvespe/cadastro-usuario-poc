package com.estudo.cadastrousuario.service.exception;

import com.estudo.cadastrousuario.api.exception.BaseException;

public class UsuarioNaoLocalizado extends BaseException {
    public UsuarioNaoLocalizado(Long id) {
        super(String.format("Usuario : { %d } não localizado na base de dados.",id));
    }
}
