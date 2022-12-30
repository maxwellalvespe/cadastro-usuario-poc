package com.estudo.cadastrousuario.service;

import com.estudo.cadastrousuario.domain.Enquete;

import java.util.List;

public interface EnqueteService {
    List<Enquete> listar();

    Enquete salvar(Enquete enquete);
}
