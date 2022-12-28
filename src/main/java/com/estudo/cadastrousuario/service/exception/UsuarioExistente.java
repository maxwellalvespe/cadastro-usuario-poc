package com.estudo.cadastrousuario.service.exception;

import com.estudo.cadastrousuario.api.exception.BaseException;
import org.springframework.core.task.TaskExecutor;

public class UsuarioExistente extends BaseException {

    public UsuarioExistente(String message) {
        super(message);
    }

}
