package com.estudo.cadastrousuario.service.impl;

import com.estudo.cadastrousuario.domain.Enquete;
import com.estudo.cadastrousuario.domain.Usuario;
import com.estudo.cadastrousuario.domain.Votacao;
import com.estudo.cadastrousuario.domain.enums.Voto;
import com.estudo.cadastrousuario.repository.EnqueteRepository;
import com.estudo.cadastrousuario.repository.UsuarioRepository;
import com.estudo.cadastrousuario.repository.VotacaoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
@Slf4j
public class VotacaoServiceImpl {
    private final VotacaoRepository repository;
    private final UsuarioRepository usuarioRepository;
    private final EnqueteRepository enqueteRepository;


    public Votacao salvar(Long idUsuario, Long idEnquete, String voto) {

        Usuario usuario = usuarioRepository.findById(idUsuario).orElseThrow();
        Enquete enquete = enqueteRepository.findById(idEnquete).orElseThrow();

        var vot = new Votacao(null, enquete, usuario, Voto.valueOf(voto.toUpperCase()));
        return repository.save(vot);
    }

    public List<Votacao> findAll() {
        return repository.findAll();
    }

    public Map<String, Integer> resultadoVotacao(Long idEnquete) {
        Map<String, Integer> contagemDosVotos = new HashMap<>();

        List<Votacao> responseDB = repository.findAll();

        contagemDosVotos.put(Voto.SIM.name(), responseDB.stream()
                .filter(e -> e.getEnquete().getId().equals(idEnquete))
                .map(Votacao::getVoto)
                .filter(f -> f.name().equals("SIM")).toList().size());

        contagemDosVotos.put(Voto.NAO.name(), responseDB.stream()
                .filter(e-> e.getEnquete().getId().equals(idEnquete))
                .map(Votacao::getVoto)
                .filter(f-> f.name().equals("NAO")).toList().size());

        return contagemDosVotos;
    }
}
