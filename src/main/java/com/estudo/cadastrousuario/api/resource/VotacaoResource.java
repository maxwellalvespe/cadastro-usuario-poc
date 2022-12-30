package com.estudo.cadastrousuario.api.resource;


import com.estudo.cadastrousuario.api.exception.BaseException;
import com.estudo.cadastrousuario.domain.Enquete;
import com.estudo.cadastrousuario.domain.Votacao;
import com.estudo.cadastrousuario.domain.enums.Voto;
import com.estudo.cadastrousuario.repository.EnqueteRepository;
import com.estudo.cadastrousuario.repository.VotacaoRepository;
import com.estudo.cadastrousuario.repository.UsuarioRepository;
import com.estudo.cadastrousuario.service.impl.VotacaoServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@RestController
@RequestMapping("votacao")
@RequiredArgsConstructor
public class VotacaoResource {

    private final VotacaoServiceImpl service;

    @PostMapping(path = "/{idUsuario}/enquetes/{idEnquete}/votar")
    public ResponseEntity<Votacao> votar(@PathVariable Long idUsuario,
                                         @PathVariable Long idEnquete,
                                         @RequestParam String opcao) {

        Votacao response = service.salvar(idUsuario, idEnquete, opcao);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Votacao>> finall() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/resultados/enquete/{idEnquete}")
    public ResponseEntity<Map<String, Integer>> votos(@PathVariable Long idEnquete) {
        return new ResponseEntity<>(service.resultadoVotacao(idEnquete), HttpStatus.OK);

    }
}
