package com.estudo.cadastrousuario.api.resource;

import com.estudo.cadastrousuario.api.exception.BaseException;
import com.estudo.cadastrousuario.api.mapper.UsuarioMapper;
import com.estudo.cadastrousuario.api.request.UsuarioRequest;
import com.estudo.cadastrousuario.api.response.UsuarioResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import padroes.padroesapi.domain.Usuario;

import java.net.URI;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class CadastroDeUsuarios {


    private final UsuarioMapper mapper;


    @PostMapping
    public ResponseEntity<UsuarioResponse> cadastarUsuario( @Valid @RequestBody UsuarioRequest usuarario) {

        Usuario usuario = mapper.toUsuario(usuarario);

        return ResponseEntity.created(URI.create("/usuario")).body(mapper.toResp(usuario));
    }
}
