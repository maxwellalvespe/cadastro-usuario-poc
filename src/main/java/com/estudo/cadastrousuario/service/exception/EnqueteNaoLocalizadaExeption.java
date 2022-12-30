package com.estudo.cadastrousuario.service.exception;

import com.estudo.cadastrousuario.api.exception.BaseException;

public class EnqueteNaoLocalizadaExeption extends BaseException {

    public EnqueteNaoLocalizadaExeption(Long idEnquete) {
        super(String.format("O número da enquete informada {%d} não foi localizado na base de dado's.",idEnquete));
    }
}
