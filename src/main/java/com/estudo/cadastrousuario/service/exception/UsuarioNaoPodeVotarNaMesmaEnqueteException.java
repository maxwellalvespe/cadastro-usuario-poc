package com.estudo.cadastrousuario.service.exception;

import com.estudo.cadastrousuario.api.exception.BaseException;

public class UsuarioNaoPodeVotarNaMesmaEnqueteException extends BaseException {
    public UsuarioNaoPodeVotarNaMesmaEnqueteException(Long id,Long enquete) {
        super(String.format("Voto não permitido!  Usuário : { %d } já votou na enquete {%d}.",id ,enquete));
    }
}
