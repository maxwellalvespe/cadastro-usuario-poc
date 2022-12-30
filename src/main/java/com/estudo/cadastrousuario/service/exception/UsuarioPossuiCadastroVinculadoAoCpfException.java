package com.estudo.cadastrousuario.service.exception;

import com.estudo.cadastrousuario.api.exception.BaseException;

public class UsuarioPossuiCadastroVinculadoAoCpfException extends BaseException {
    public UsuarioPossuiCadastroVinculadoAoCpfException(String message) {
        super(String.format("Usuário possui cadastro para o cpf informado : { %s }",message));
    }
}
