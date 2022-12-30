package com.estudo.cadastrousuario.service;

import java.util.List;
import java.util.Map;
import com.estudo.cadastrousuario.domain.Votacao;
import com.estudo.cadastrousuario.domain.enums.Voto;

public interface VotacaoService {
    Votacao salvar(Long idUsuario, Long idEnquete, Voto voto);

    List<Votacao> findAll();

    Map<String,Integer> resultadoVotacao(Long idEnquete);
}
