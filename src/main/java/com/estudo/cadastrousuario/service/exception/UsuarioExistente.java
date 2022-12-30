package com.estudo.cadastrousuario.service.exception;

import com.estudo.cadastrousuario.api.exception.BaseException;

public class UsuarioExistente extends BaseException {

    public UsuarioExistente(String message) {
        super(message);
    }

}
