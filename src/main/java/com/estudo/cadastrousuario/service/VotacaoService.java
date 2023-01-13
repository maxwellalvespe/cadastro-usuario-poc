package com.estudo.cadastrousuario.service;

import com.estudo.cadastrousuario.domain.Votacao;
import com.estudo.cadastrousuario.domain.enums.Voto;

import java.util.List;
import java.util.Map;

public interface VotacaoService {
    Votacao salvar(Long idUsuario, Long idEnquete, Voto voto);

    List<Votacao> findAll();

    Map<String,Integer> resultadoVotacao(Long idEnquete);
}
