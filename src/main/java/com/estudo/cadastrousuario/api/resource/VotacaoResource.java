package com.estudo.cadastrousuario.api.resource;


import com.estudo.cadastrousuario.domain.Votacao;
import com.estudo.cadastrousuario.domain.enums.Voto;
import com.estudo.cadastrousuario.service.VotacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("votacao")
@RequiredArgsConstructor
public class VotacaoResource {

    private final VotacaoService service;

    @PostMapping(path = "/usuarios/{idUsuario}/enquetes/{idEnquete}/votar")
    public ResponseEntity<Votacao> registrarVoto(@PathVariable Long idUsuario,
                                                 @PathVariable Long idEnquete,
                                                 @RequestParam Voto voto) {
        return new ResponseEntity<>(service.salvar(idUsuario, idEnquete, voto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Votacao>> listarVotacao() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/resultados/enquetes/{idEnquete}")
    public ResponseEntity<Map<String, Integer>> exibirResultado(@PathVariable Long idEnquete) {
        return new ResponseEntity<>(service.resultadoVotacao(idEnquete), HttpStatus.OK);

    }
}
