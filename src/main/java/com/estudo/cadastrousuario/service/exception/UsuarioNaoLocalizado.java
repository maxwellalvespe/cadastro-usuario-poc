package com.estudo.cadastrousuario.service.exception;

import com.estudo.cadastrousuario.api.exception.BaseException;

public class UsuarioNaoLocalizado extends BaseException {
    public UsuarioNaoLocalizado(String message) {
        super(message);
    }
}
