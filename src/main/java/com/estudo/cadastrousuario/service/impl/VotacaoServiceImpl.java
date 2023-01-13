package com.estudo.cadastrousuario.service.impl;

import com.estudo.cadastrousuario.domain.Enquete;
import com.estudo.cadastrousuario.domain.Usuario;
import com.estudo.cadastrousuario.domain.Votacao;
import com.estudo.cadastrousuario.domain.enums.Voto;
import com.estudo.cadastrousuario.repository.EnqueteRepository;
import com.estudo.cadastrousuario.repository.UsuarioRepository;
import com.estudo.cadastrousuario.repository.VotacaoRepository;
import com.estudo.cadastrousuario.service.VotacaoService;
import com.estudo.cadastrousuario.service.exception.EnqueteNaoLocalizadaExeption;
import com.estudo.cadastrousuario.service.exception.UsuarioNaoLocalizado;
import com.estudo.cadastrousuario.service.exception.UsuarioNaoPodeVotarNaMesmaEnqueteException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class VotacaoServiceImpl implements VotacaoService {
    private final VotacaoRepository repository;
    private final UsuarioRepository usuarioRepository;
    private final EnqueteRepository enqueteRepository;


    public Votacao salvar(Long userId, Long idEnquete, Voto voto) throws UsuarioNaoLocalizado, EnqueteNaoLocalizadaExeption {

        verificarLegibilidadeDoVoto(userId, idEnquete);

        Usuario usuario = usuarioRepository.findById(userId).orElseThrow(() -> new UsuarioNaoLocalizado(userId));
        Enquete enquete = enqueteRepository.findById(idEnquete).orElseThrow(() -> new EnqueteNaoLocalizadaExeption(idEnquete));

        var vot = new Votacao(null, enquete, usuario, voto);
        return repository.save(vot);
    }

    public List<Votacao> findAll() {
        return repository.findAll();
    }

    public Map<String, Integer> resultadoVotacao(Long idEnquete) {

        Map<String, Integer> votos = new HashMap<>();

        List<Votacao> responseDB = repository.findByEnqueteId(idEnquete)
                .filter(f -> f.size() > 0)
                .orElseThrow(() -> new EnqueteNaoLocalizadaExeption(idEnquete));

        calcularVotosObtidos(votos, Voto.SIM, responseDB, idEnquete);

        calcularVotosObtidos(votos, Voto.NAO, responseDB, idEnquete);

        return votos;
    }

    private void calcularVotosObtidos(Map<String, Integer> votos, Voto voto, List<Votacao> responseDB, Long idEnquete) {
        votos.put(voto.name(), responseDB.stream()
                .filter(e -> e.getEnquete().getId().equals(idEnquete))
                .map(Votacao::getVoto)
                .filter(f -> f.name().equals(voto.name())).toList().size());

    }

    private void verificarLegibilidadeDoVoto(Long idUsuario, Long idEnquete) {
        repository.findByEnqueteId(idEnquete)
                .ifPresent(m -> m.forEach(e -> {
                    isValid(e, idUsuario);
                }));
    }

    private void isValid(Votacao v, Long user) {
        if (Objects.equals(v.getUsuario().getId(), user)) {
            throw new UsuarioNaoPodeVotarNaMesmaEnqueteException(user, v.getEnquete().getId());
        }
    }
}
