package com.estudo.cadastrousuario.api.resource;


import com.estudo.cadastrousuario.api.exception.BaseException;
import com.estudo.cadastrousuario.domain.Enquete;
import com.estudo.cadastrousuario.domain.Votacao;
import com.estudo.cadastrousuario.domain.enums.Voto;
import com.estudo.cadastrousuario.repository.EnqueteRepository;
import com.estudo.cadastrousuario.repository.VotacaoRepository;
import com.estudo.cadastrousuario.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("votacao")
@RequiredArgsConstructor
public class VotacaoResource {

    private final VotacaoRepository repository;
    private final UsuarioRepository usuarioRepository;
    private final EnqueteRepository enqueteRepository;

    @PostMapping(path = "/{idUsuario}/enquetes/{idEnquete}/votar")
    public ResponseEntity<Votacao> votar(@PathVariable Long idUsuario,
                                         @PathVariable Long idEnquete,
                                         @RequestParam String opcao) {

        var usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new BaseException("Usuario não localizado"));

        Enquete enquete = enqueteRepository.findById(idEnquete).orElseThrow(() -> new BaseException("Enquete não localizada."));

        Votacao resultado = new Votacao();
        resultado.setVoto(Voto.valueOf(opcao.toUpperCase()));
        resultado.setUsuario(usuario);
        resultado.setEnquete(enquete);

        var response = repository.save(resultado);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
